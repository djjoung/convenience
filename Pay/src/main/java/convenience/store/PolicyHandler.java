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
    @Autowired PayHistoryRepository payHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_Cancel(@Payload ReservationCancelled reservationCancelled){

        if(!reservationCancelled.validate()) return;

        System.out.println("\n\n##### listener Cancel : " + reservationCancelled.toJson() + "\n\n");



        // Sample Logic //
        // PayHistory payHistory = new PayHistory();
        // payHistoryRepository.save(payHistory);

    }
    /* 중복 생성으로 주석처리 
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_Cancel(@Payload ReservationCancelled reservationCancelled){

        if(!reservationCancelled.validate()) return;

        System.out.println("\n\n##### listener Cancel : " + reservationCancelled.toJson() + "\n\n");



        // Sample Logic //
        // PayHistory payHistory = new PayHistory();
        // payHistoryRepository.save(payHistory);

    }
    */

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}