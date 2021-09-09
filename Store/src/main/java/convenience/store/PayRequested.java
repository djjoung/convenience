package convenience.store;

public class PayRequested extends AbstractEvent {
    
	private Long id;
    private String payStatus;
    private Long productId;
    private Integer reserveQty;
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private Long reserveId;
    private String reserveStatus;
    private String reserveDate;
    
    public PayRequested(){
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

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
    
    
}