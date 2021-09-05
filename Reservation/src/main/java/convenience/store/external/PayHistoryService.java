package convenience.store.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Pay", url="http://localhost:8082/")
public interface PayHistoryService {
    @RequestMapping(method= RequestMethod.POST, path="/payHistories/request")
    public boolean request(@RequestBody PayHistory payHistory);

}
