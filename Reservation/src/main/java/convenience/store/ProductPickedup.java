package convenience.store;

public class ProductPickedup extends AbstractEvent {

    private Long id;
    private Long reserveId;
    private String productName;
    private Integer productPrice;
    private Integer productQty;    
    private String productStatus;

    public ProductPickedup(){
        super();
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
    
    
}