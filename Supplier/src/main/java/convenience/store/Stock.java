package convenience.store;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Stock_table")
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long productId;
    private String productName;
    private Integer productQty;

    @PostPersist
    public void onPostPersist(){
        ProductDelivered productDelivered = new ProductDelivered();
        BeanUtils.copyProperties(this, productDelivered);
        productDelivered.publishAfterCommit();
        productDelivered.saveJasonToPvc(productDelivered.toJson());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }




}