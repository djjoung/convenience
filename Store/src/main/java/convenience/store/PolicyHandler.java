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
    @Autowired ProductRepository productRepository;
    @Autowired StoreReservationRepository storeReservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayRequested_Reserve(@Payload PayRequested payRequested){

        if(!payRequested.validate()) return;

        System.out.println("\n\n##### listener Reserve : " + payRequested.toJson() + "\n\n");



        // Sample Logic //
        // Product product = new Product();
        // productRepository.save(product);
        // StoreReservation storeReservation = new StoreReservation();
        // storeReservationRepository.save(storeReservation);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCancelled_ReservationCancel(@Payload PayCancelled payCancelled){

        if(!payCancelled.validate()) return;

        System.out.println("\n\n##### listener ReservationCancel : " + payCancelled.toJson() + "\n\n");



        // Sample Logic //
        // Product product = new Product();
        // productRepository.save(product);
        // StoreReservation storeReservation = new StoreReservation();
        // storeReservationRepository.save(storeReservation);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverProductDelivered_UpdateProduct(@Payload ProductDelivered productDelivered){

        if(!productDelivered.validate()) return;

        System.out.println("\n\n##### listener UpdateProduct : " + productDelivered.toJson() + "\n\n");



        // Sample Logic //
        // Product product = new Product();
        // productRepository.save(product);
        // StoreReservation storeReservation = new StoreReservation();
        // storeReservationRepository.save(storeReservation);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}