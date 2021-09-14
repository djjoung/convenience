package convenience.store;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Dashboard_table")
public class Dashboard {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long productId;
        private String productName;
        private Integer productPrice;
        private Long customerId;
        private String customerName;
        private String customerPhone;
        private Integer reserveQty;
        private String reserveDate;
        private String pickupDate;
        private Integer totalPrice;
        private Long reserveId;        
        private String reserveStatus;
        private String cancelDate;


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
        public Integer getReserveQty() {
            return reserveQty;
        }

        public void setReserveQty(Integer reserveQty) {
            this.reserveQty = reserveQty;
        }
        
        public String getReserveDate() {
			return reserveDate;
		}

		public void setReserveDate(String reserveDate) {
			this.reserveDate = reserveDate;
		}

		public String getPickupDate() {
			return pickupDate;
		}

		public void setPickupDate(String pickupDate) {
			this.pickupDate = pickupDate;
		}

		public Integer getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
        }
        public Long getReserveId() {
            return reserveId;
        }

        public void setReserveId(Long reserveId) {
            this.reserveId = reserveId;
        }
 
        public String getReserveStatus() {
            return reserveStatus;
        }

        public void setReserveStatus(String reserveStatus) {
            this.reserveStatus = reserveStatus;
        }

		public String getCancelDate() {
			return cancelDate;
		}

		public void setCancelDate(String cancelDate) {
			this.cancelDate = cancelDate;
		}
        
       
}