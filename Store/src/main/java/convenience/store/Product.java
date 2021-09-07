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
    
    // 상태별 Event 처리를 구분하기 위해 추가
    @Transient
    private String productStatus;

    @PostPersist
    public void onPostPersist(){
    			
    	if (this.getProductStatus().equals("PICKUP")) {
    		ProductPickedup productPickedup = new ProductPickedup();
            BeanUtils.copyProperties(this, productPickedup);
            productPickedup.setProductStatus("PICKUP");
            productPickedup.publishAfterCommit();
    	} else {
    		System.out.println("Nothing happened");
    	}
    	
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

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	} 
    

}