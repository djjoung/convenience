package convenience.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayHistoryController {

	@Autowired
	PayHistoryRepository payhistoryRepository;
	
	//@ApiOperation(value = "결제 진행하기")
	@PostMapping("/request")
	public boolean requestPay(@RequestBody PayHistory payHistory) {
   		PayHistory savedPayHistory = payhistoryRepository.save(payHistory);
        
		System.out.println("productId : " + payHistory.getProductId());
        System.out.println("productQyt : " + payHistory.getReserveQty());

        return true;
    }
 }