package convenience.store;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Product_table")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String productName;
    private Integer productPrice;
    private Integer productQty;

    @PostPersist
    public void onPostPersist(){
        ProductPickedup productPickedup = new ProductPickedup();
        BeanUtils.copyProperties(this, productPickedup);
        productPickedup.publishAfterCommit();

        ProductOrdered productOrdered = new ProductOrdered();
        BeanUtils.copyProperties(this, productOrdered);
        productOrdered.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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




}