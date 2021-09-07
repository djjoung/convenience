package convenience.store.external;

import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Component;

@Service
public class PayHistoryServiceImpl implements PayHistoryService {
    /**
     * Pay fallback
     */
    public boolean request(PayHistory payhistory) {
        System.out.println("@@@@@@@ 결재 지연중 입니다. @@@@@@@@@@@@");
        System.out.println("@@@@@@@ 결재 지연중 입니다. @@@@@@@@@@@@");
        System.out.println("@@@@@@@ 결재 지연중 입니다. @@@@@@@@@@@@");
        return true;
    }
}