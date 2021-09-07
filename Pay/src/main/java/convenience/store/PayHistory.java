package convenience.store;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="payhistory_table")
public class PayHistory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String payStatus;
    private String reservationStatus;
    private Long reservationId;
    private Long productId;
    private Long reserveQty;
    private Long productPrice;
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private Date reserveDate;
    private Date date;


    @PrePersist
    public void onPrePersist(){
		System.out.println("\n\n##### PayHistory onPrePersist  " + /* payRequested.toJson() + */"\n\n");

        // HPA test 용 지연 코드.
        double dLoad = 0.0001;
        for (int iCnt = 0; iCnt <= 1000000; iCnt++) {
            dLoad += Math.sqrt(dLoad);
        }           
	}


    @PostPersist
    public void onPostPersist(){

        
        
        PayRequested payRequested = new PayRequested();
        BeanUtils.copyProperties(this, payRequested);
        payRequested.publishAfterCommit();

        System.out.println("\n\n##### PayHistory onPostPersist  " + payRequested.toJson() + "\n\n");
        

        // PayCancelled payCancelled = new PayCancelled();
        // BeanUtils.copyProperties(this, payCancelled);
        // payCancelled.publishAfterCommit();

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
    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getReserveQty() {
        return reserveQty;
    }

    public void setReserveQty(Long reserveQty) {
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
    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




}
