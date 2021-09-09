package convenience.store.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

//@FeignClient(name="pay", url="http://localhost:8082/pay", fallback = PayHistoryServiceImpl.class)  // for local
@FeignClient(name="pay", url="http://pay:8080/pay", fallback = PayHistoryServiceImpl.class)  // for cloud
public interface PayHistoryService {
	
    @RequestMapping(method= RequestMethod.POST, path="/request")
    public boolean request(@RequestBody PayHistory payHistory);

}

