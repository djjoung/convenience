package convenience.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class PayHistoryController {

    @Autowired
    PayHistoryRepository payHistoryRepository;



    @PostMapping("/payHistories/request")
    
    public boolean request(@RequestBody PayHistory payHistory)
    {
        System.out.println("productId : " + payHistory.getProductId());
        System.out.println("productQyt : " + payHistory.getReserveQty());

        return true;

    }
 }