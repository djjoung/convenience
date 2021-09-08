package convenience.store;

public class PayCancelled extends AbstractEvent {
    
    private String payStatus;
    private String reserveStatus;
    private Long productId;
    private Long reserveQty;
    private Long reserveId;

    public PayCancelled(){
        super();
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

	public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
}