package convenience.store;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	 
	@Autowired
	ProductRepository productRepository;
	 
	@Autowired
	StoreReservationRepository storeReservationRepository;
	 
	//@ApiOperation(value = "상품 전체 조회")
	@GetMapping("/list")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> productList = productRepository.findAll();
		return ResponseEntity.ok(productList);
	}

	//@ApiOperation(value = "상품 주문")
	@PostMapping("/order")
	public ResponseEntity<Product> orderProduct(@RequestBody Product product) {
		int orderedProductQty = product.getProductQty();
		product.setProductStatus("ORDER");
		Product findedProduct = productRepository.findByProductName(product.getProductName());
		ProductOrdered productOrdered = new ProductOrdered();
		 
		if (findedProduct == null) { // 상품이 없는 경우 갯수를 0개로 최초 생성한다
			product.setProductQty(0);
			product = productRepository.save(product);
			BeanUtils.copyProperties(product, productOrdered);
		} else {
			BeanUtils.copyProperties(findedProduct, productOrdered);			 
		}       
                 
		productOrdered.setProductQty(orderedProductQty); // 기존에 있던 상품의 갯수가 아닌 주문한 상품 갯수로 셋팅 
        productOrdered.publish();
		 
		return ResponseEntity.ok(product);
	}
	 
	//@ApiOperation(value = "상품 찾아가기")
	@GetMapping("/pickup/{id}")
	public ResponseEntity<Product> pickupProduct(@PathVariable Long reserveId) {
		try {
			StoreReservation reservation = storeReservationRepository.findById(reserveId).orElseThrow(null);
			Product product = productRepository.findById(reservation.getProductId()).orElseThrow(null);			 
			product.setProductQty(product.getProductQty() - reservation.getReserveQty());
			product.setProductStatus("PICKUP");
			productRepository.save(product);			 
			return ResponseEntity.ok(product);			 
		} catch(Exception e) {
			System.out.println("pickupProduct Error : " + e);
			return null;
		}		 
	}
}