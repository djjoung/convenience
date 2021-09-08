package convenience.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

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
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private Integer qty;
    
    @PrePersist
    public void onPrePersist() {   	
        
        convenience.store.external.PayHistory payHistory = new convenience.store.external.PayHistory();
        
        payHistory.setPayStatus(this.status);
        payHistory.setReservationStatus(this.status);
        payHistory.setReservationId(this.id);
        payHistory.setCustomerId(this.customerId);
        payHistory.setCustomerName(this.customerName);
        payHistory.setCustomerPhone(this.customerPhone);
        payHistory.setDate(this.date);
        payHistory.setDate(this.date);
        payHistory.setProductId(this.productId);
        payHistory.setProductPrice(this.productPrice);
        payHistory.setReserveQty(this.qty);
        
        boolean result = ReservationApplication.applicationContext.getBean(convenience.store.external.PayHistoryService.class).request(payHistory);
        
        if(result) {
        	System.out.println("########## 결제가 완료되었습니다 ############");
            //ProductReserved productReserved = new ProductReserved();
            //BeanUtils.copyProperties(this, productReserved);
            //productReserved.publishAfterCommit();
        }else{
            System.out.println("########## 결제가 실패하였습니다 ############");
        }

        // CB test 용 지연 코드.
        try {
            Thread.currentThread().sleep((long) (400 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    
    @PostPersist
    public void onPostPersist() {
    	ProductReserved productReserved = new ProductReserved();
    	BeanUtils.copyProperties(this, productReserved);
        productReserved.setReserveQty(this.qty);
        productReserved.publishAfterCommit();
    }
    
    @PostUpdate
    public void onPostUpdate() {
    	if (this.status.equals("CANCEL")) {    
	    	ReservationCancelled reservationCancelled = new ReservationCancelled();
	        BeanUtils.copyProperties(this, reservationCancelled);
	        reservationCancelled.publishAfterCommit();
    	}
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
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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