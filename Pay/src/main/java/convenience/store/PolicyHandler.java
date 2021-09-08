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
    PayHistoryRepository payHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_Cancel(@Payload ReservationCancelled reservationCancelled){

        if(!reservationCancelled.validate()) return;
        System.out.println("\n\n##### listener Cancel : " + reservationCancelled.toJson() + "\n\n");

        if (reservationCancelled.getStatus().equals("CANCEL")) {
        	PayHistory payHistory = payHistoryRepository.findById(reservationCancelled.getId()).orElseThrow(null);
        	payHistory.setPayStatus("CANCEL");
        	payHistory.setReserveStatus("CANCEL");
        	payHistoryRepository.save(payHistory);        	
        }        
        
    }

}