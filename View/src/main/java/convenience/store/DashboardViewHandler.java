package convenience.store;

import convenience.store.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardViewHandler {


    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductReserved_then_CREATE_1 (@Payload ProductReserved productReserved) {
        try {

            if (!productReserved.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setId(productReserved.getProductId());
            dashboard.setProductName(productReserved.getProductName());
            dashboard.setProductPrice(productReserved.getProductPrice());
            dashboard.setReserveQty(productReserved.getReserveQty());
            dashboard.setCustomerId(productReserved.getCustomerId());
            dashboard.setCustomerName(productReserved.getCustomerName());
            dashboard.setCustomerPhone(productReserved.getCustomerPhone());
            dashboard.setReserveId(productReserved.getId());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayRequested_then_UPDATE_1(@Payload PayRequested payRequested) {
        try {
            if (!payRequested.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByReserveId(payRequested.getReservationId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setPayHistoryId(payRequested.getId());
                    dashboard.setPayHistoryStatus(payRequested.getPayStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCancelled_then_UPDATE_2(@Payload PayCancelled payCancelled) {
        try {
            if (!payCancelled.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByReserveId(payCancelled.getReserveId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setPayHistoryStatus(payCancelled.getPayStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenStockReserved_then_UPDATE_3(@Payload StockReserved stockReserved) {
        try {
            if (!stockReserved.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByReserveStatus(stockReserved.getReserveStatus());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setReserveId(stockReserved.getReserveId());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenStockReserveCancelled_then_UPDATE_4(@Payload StockReserveCancelled stockReserveCancelled) {
        try {
            if (!stockReserveCancelled.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByReserveStatus(stockReserveCancelled.getReserveStatus());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setReserveId(stockReserveCancelled.getReserveId());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

