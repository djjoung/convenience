package convenience.store;

import convenience.store.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
	
    @Autowired 
    StockRepository stockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverProductOrdered_ProductOrdered(@Payload ProductOrdered productOrdered){

        if(!productOrdered.validate()) return;
        System.out.println("\n\n##### listener ProductOrdered : " + productOrdered.toJson() + "\n\n");
        
        Stock stock = new Stock();
        stock.setProductId(productOrdered.getId());
        stock.setProductName(productOrdered.getProductName());
        stock.setProductQty(productOrdered.getProductQty());
        stockRepository.save(stock);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}