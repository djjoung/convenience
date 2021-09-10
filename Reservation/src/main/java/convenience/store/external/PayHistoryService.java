package convenience.store.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="pay", url="${api.url.pay}", fallback = PayHistoryServiceImpl.class)
public interface PayHistoryService {
	
    @RequestMapping(method= RequestMethod.POST, path="/request")
    public boolean request(@RequestBody PayHistory payHistory);

}

