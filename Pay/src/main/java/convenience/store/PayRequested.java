package convenience.store;

public class PayRequested extends AbstractEvent {
    
    private String payStatus;
    private Long productId;
    private Long reserveQty;
    private Long customerId;
    private String customerName;
    private Long reserveId;

    public PayRequested(){
        super();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
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
    
    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
}