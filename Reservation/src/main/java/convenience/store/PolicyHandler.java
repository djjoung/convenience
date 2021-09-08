package convenience.store;

import convenience.store.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
	
	@Autowired 
	ReservationRepository reservationRepository;

	@StreamListener(KafkaProcessor.INPUT)
    public void wheneverProduct_Pickedup(@Payload ProductPickedup productPickedup){

        if(!productPickedup.validate()) return;
        System.out.println("\n\n##### listener Reserve : " + productPickedup.toJson() + "\n\n");
        
        Reservation reservation = reservationRepository.findById(productPickedup.getReserveId()).orElseThrow();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(Calendar.getInstance().getTime());
		reservation.setDate(dateStr);
        reservation.setStatus("PICKUP");
        
        reservationRepository.save(reservation);
        
    }

}