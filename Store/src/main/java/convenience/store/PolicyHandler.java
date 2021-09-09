package convenience.store;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import convenience.store.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler {
    
	@Autowired 
    ProductRepository productRepository;
    
    @Autowired 
    StoreReservationRepository storeReservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayRequested_Reserve(@Payload PayRequested payRequested){

        if(!payRequested.validate()) return;
        System.out.println("\n\n##### listener Reserve : " + payRequested.toJson() + "\n\n");
        
        StoreReservation storeReservation = new StoreReservation();
        BeanUtils.copyProperties(payRequested, storeReservation);
        storeReservationRepository.save(storeReservation);
        
        // 예약이 되면 상품의 보유 갯수를 줄여준다  
        Product product = productRepository.findById(payRequested.getProductId()).orElseThrow(null);
        product.setProductQty(product.getProductQty() - payRequested.getReserveQty());
        productRepository.save(product);
        
    }
    
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCancelled_ReservationCancel(@Payload PayCancelled payCancelled){

        if(!payCancelled.validate()) return;
        System.out.println("\n\n##### listener ReservationCancel : " + payCancelled.toJson() + "\n\n");
        StoreReservation storeReservation = storeReservationRepository.findByReserveId(payCancelled.getReserveId());
        storeReservation.setReserveStatus(payCancelled.getReserveStatus());
        
        storeReservationRepository.save(storeReservation);
        
        // 예약이 취소되는 상품의 보유 갯수를 늘려준다 
        Product product = productRepository.findById(payCancelled.getProductId()).orElseThrow(null);
        product.setProductQty(product.getProductQty() + payCancelled.getReserveQty());
        productRepository.save(product);

    }
    
    // Stock에서 제품이 전달되었을때 제품의 갯수를 늘려준다 
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverProductDelivered_UpdateProduct(@Payload ProductDelivered productDelivered){

        if(!productDelivered.validate()) return;
        System.out.println("\n\n##### listener UpdateProduct : " + productDelivered.toJson() + "\n\n");
        
        Product product = productRepository.findById(productDelivered.getProductId()).orElseThrow(null);
        product.setProductQty(product.getProductQty() + productDelivered.getProductQty());        
        productRepository.save(product);
    }

}