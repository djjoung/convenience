package convenience.store;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="storereservation_table")
public class StoreReservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reserveId;
    private Long productId;    
    private Integer reserveQty;
    private String reserveDate;
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String reserveStatus;
    
    @PostUpdate
    public void onPostUpdate(){    	
    	if ("PICKUP".equals(this.getReserveStatus())) {    		
    		ProductPickedup productPickedup = new ProductPickedup();
            BeanUtils.copyProperties(this, productPickedup);            
            productPickedup.publishAfterCommit();
            productPickedup.saveJasonToPvc(productPickedup.toJson());
    	} else {
    		System.out.println("############ Nothing happened");
    	}    	
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
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
    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }




}