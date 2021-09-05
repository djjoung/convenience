package convenience.store;

public class ProductOrdered extends AbstractEvent {

    private Long id;
    private String stockName;
    private Integer stockPrice;
    private Integer sotckQty;

    public ProductOrdered(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public Integer getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Integer stockPrice) {
        this.stockPrice = stockPrice;
    }
    public Integer getSotckQty() {
        return sotckQty;
    }

    public void setSotckQty(Integer sotckQty) {
        this.sotckQty = sotckQty;
    }
}