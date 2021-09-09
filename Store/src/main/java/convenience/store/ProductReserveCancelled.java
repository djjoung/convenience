package convenience.store;

public class ProductReserveCancelled extends AbstractEvent {

    private Long id;
    private Integer reserveId;
    private Integer productId;
    private String productName;
    private Integer reserveQty;
    private String reserveStatus;

    public ProductReserveCancelled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }
    
    public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getReserveQty() {
        return reserveQty;
    }

    public void setReserveQty(Integer reserveQty) {
        this.reserveQty = reserveQty;
    }
    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }
}