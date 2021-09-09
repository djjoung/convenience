package convenience.store;

public class PayCancelled extends AbstractEvent {
    
	private Long id;
    private String payStatus;
    private String reserveStatus;
    private Long productId;
    private Integer reserveQty;
    private Long reserveId;

    public PayCancelled(){
        super();
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

	public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
}