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
        
		System.out.println("$$$$$$$$$$  결재 진행됨 . ##########");

        // CB test 용 지연 코드.
        try {
            Thread.currentThread().sleep((long) (400 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }		
		
		return true;
	}
}