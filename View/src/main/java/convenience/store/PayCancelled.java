package convenience.store;

public class PayCancelled extends AbstractEvent {

    private Long id;
    private String payStatus;
    private String reservationStatus;
    private Long productId;
    private Long reserveQty;
    private Long reserveId;

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
    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
}