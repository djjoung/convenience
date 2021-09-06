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
	 
	//@ApiOperation(value = "��ǰ ��ü ��ȸ")
	 @GetMapping("/list")
	 public ResponseEntity<List<Product>> getProducts() {
		 List<Product> productList = productRepository.findAll();
		 return ResponseEntity.ok(productList);
	 }

	 //@ApiOperation(value = "��ǰ �ֹ�")
	 @PostMapping("/order")
	 public ResponseEntity<Product> orderProduct(@RequestBody Product product) {
		 int orderedProductQty = product.getProductQty();
		 product.setProductStatus("ORDER");
		 Product findedProduct = productRepository.findByProductName(product.getProductName());
		 ProductOrdered productOrdered = new ProductOrdered();
		 
		 if (findedProduct == null) { // ��ǰ�� ���� ��� ������ 0���� ���� �����Ѵ�
			 product.setProductQty(0);
			 product = productRepository.save(product);
			 BeanUtils.copyProperties(product, productOrdered);
		 } else {
			 BeanUtils.copyProperties(findedProduct, productOrdered);			 
		 }       
                 
		 productOrdered.setProductQty(orderedProductQty); // ������ �ִ� ��ǰ�� ������ �ƴ� �ֹ��� ��ǰ ������ ���� 
         productOrdered.publish();
		 
		 return ResponseEntity.ok(product);
	 }
	 
	//@ApiOperation(value = "��ǰ ã�ư���")
	 @GetMapping("/pickup/{id}")
	 public ResponseEntity<Product> pickupProduct(@PathVariable Long reserveId) {
		 try {
			 StoreReservation reservation = storeReservationRepository.findById(reserveId).orElseThrow();
			 Product product = productRepository.findById(reservation.getProductId()).orElseThrow();			 
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