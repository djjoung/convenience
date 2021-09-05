package convenience.store;

public class ProductOrdered extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer productPrice;
    private Integer productQty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStockName() {
        return productName;
    }

    public void setStockName(String productName) {
        this.productName = productName;
    }
    public Integer getStockPrice() {
        return productPrice;
    }

    public void setStockPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
    public Integer getSotckQty() {
        return productQty;
    }

    public void setSotckQty(Integer productQty) {
        this.productQty = productQty;
    }
}