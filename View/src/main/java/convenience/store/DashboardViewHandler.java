package convenience.store;

import convenience.store.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardViewHandler {


    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductReserved_then_create(@Payload ProductReserved productReserved) {
        try {

            if (!productReserved.validate()) return;
            System.out.println("\n\n##### listener ProductReserved : " + productReserved.toJson() + "\n\n");

            // view 객체 생성
            Dashboard dashboard = new Dashboard();            

            dashboard.setProductId(productReserved.getProductId());
            dashboard.setProductName(productReserved.getProductName());
            dashboard.setProductPrice(productReserved.getProductPrice());
            dashboard.setCustomerId(productReserved.getCustomerId());
            dashboard.setCustomerName(productReserved.getCustomerName());
            dashboard.setCustomerPhone(productReserved.getCustomerPhone());
            dashboard.setReserveId(productReserved.getId());
            dashboard.setReserveQty(productReserved.getReserveQty());
            dashboard.setReserveDate(productReserved.getReserveDate());
            dashboard.setReserveStatus(productReserved.getStatus());
            dashboard.setTotalPrice(productReserved.getReserveQty() * productReserved.getProductPrice());

            dashboardRepository.save(dashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCancelled_then_update(@Payload PayCancelled payCancelled) {
        try {
            if (!payCancelled.validate()) return;

            Dashboard dashboard = dashboardRepository.findByReserveId(payCancelled.getReserveId());
              
            dashboard.setReserveStatus(payCancelled.getReserveStatus());
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = format.format(Calendar.getInstance().getTime());
			dashboard.setCancelDate(dateStr);
			
            dashboardRepository.save(dashboard);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductPickedup_then_update(@Payload ProductPickedup productPickup) {
        try {
            if (!productPickup.validate()) return;

			Dashboard dashboard = dashboardRepository.findByReserveId(productPickup.getReserveId());
			dashboard.setReserveStatus(productPickup.getReserveStatus());
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = format.format(Calendar.getInstance().getTime());
			dashboard.setPickupDate(dateStr);
			
			dashboardRepository.save(dashboard);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

