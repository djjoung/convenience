package convenience.store.external;

import java.util.Date;

public class PayHistory {

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
