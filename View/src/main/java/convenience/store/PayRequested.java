package convenience.store;

public class PayRequested extends AbstractEvent {

    private Long id;
    private String payStatus;
    private Long productId;
    private Long reserveQty;
    private Long customerId;
    private String customerName;
    private Long reservationId;

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
    public Long getStockId() {
        return productId;
    }

    public void setStockId(Long productId) {
        this.productId = productId;
    }
    public Long getStockQty() {
        return reserveQty;
    }

    public void setStockQty(Long reserveQty) {
        this.reserveQty = reserveQty;
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
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}