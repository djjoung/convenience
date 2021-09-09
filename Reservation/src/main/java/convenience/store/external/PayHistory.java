package convenience.store.external;

public class PayHistory {
    
    private String payStatus;
    private String reserveStatus;
    private Long reserveId;
    private Long productId;
    private Integer reserveQty;
    private Integer productPrice;
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String reserveDate;
    private String date;

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
    public Integer getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Integer productPrice) {
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
