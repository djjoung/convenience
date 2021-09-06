package convenience.store;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Reservation_table")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String status;
    private String date;
    private Long productId;
    private String productName;
    private Integer productPrice;
    private String customerId;
    private String customerName;
    private String customerPhone;
    private Integer qty;

    @PrePersist  // ProductReserved  Req/Res 동작 확인
    public void onPrePersist(){
        convenience.store.external.PayHistory payHistory = new convenience.store.external.PayHistory();
        // mappings goes here
        //boolean bRet = Application.applicationContext.getBean(convenience.store.external.PayHistoryService.class)
        //    .request(payHistory);
        
        // copy information Reservation to PayHistory
        payHistory.setProductId(this.getProductId());
        payHistory.setReserveQty(Long.valueOf(this.getQty()));

        System.out.println("\n\n##### Reservation onPrePersist Check Pay Service : "/*+ productReserved.toJson() */+ "\n\n");
        boolean bRet = ReservationApplication.applicationContext.getBean(convenience.store.external.PayHistoryService.class)
            .request(payHistory);
        
        if (bRet){
            System.out.println("\n\n##### Reservation onPrePersist Sucess : "/*+ productReserved.toJson() */+ "\n\n");
            ProductReserved productReserved = new ProductReserved();
            BeanUtils.copyProperties(this, productReserved);
            productReserved.publishAfterCommit();
        }else{
            System.out.println("\n\n##### Reservation onPrePersist Fail : "/* + productReserved.toJson() */+ "\n\n");
        }

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
    }


@PostPersist
    public void onPostPersist(){
        ProductReserved productReserved = new ProductReserved();
        BeanUtils.copyProperties(this, productReserved);
        productReserved.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        convenience.store.external.PayHistory payHistory = new convenience.store.external.PayHistory();
        // mappings goes here
        ReservationApplication.applicationContext.getBean(convenience.store.external.PayHistoryService.class).request(payHistory);

        ReservationCancelled reservationCancelled = new ReservationCancelled();
        BeanUtils.copyProperties(this, reservationCancelled);
        reservationCancelled.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}