package convenience.store;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name="payhistory_table")
public class PayHistory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String payStatus;
    private String reserveStatus;
    private Long reserveId;
    private Long productId;
    private Integer reserveQty;
    private Long productPrice;
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String reserveDate;
    private String date;

    @PostPersist
    public void onPostPersist() {
    	if(this.reserveStatus.equals("RESERVE")) {
    		PayRequested payRequested = new PayRequested();
    		BeanUtils.copyProperties(this, payRequested);    		
    		payRequested.publishAfterCommit();

            payRequested.saveJasonToPvc(payRequested.toJson());

    	}
    }
    
    @PostUpdate
    public void onPostUpdate() {
    	if(this.payStatus.equals("CANCEL")) {
    		PayCancelled payCancelled = new PayCancelled();   
    		BeanUtils.copyProperties(this, payCancelled);
            payCancelled.publishAfterCommit();	

            payCancelled.saveJasonToPvc(payCancelled.toJson());
    	}
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }
    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getReserveQty() {
        return reserveQty;
    }

    public void setReserveQty(Integer reserveQty) {
        this.reserveQty = reserveQty;
    }
    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
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
    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




}