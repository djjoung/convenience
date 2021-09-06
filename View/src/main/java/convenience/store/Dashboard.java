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
        private Date reserveDate;
        private Date pickupDate;
        private Integer totalPrice;
        private Long reserveId;
        private Long payHistoryId;
        private String payHistoryStatus;
        private String reserveStatus;


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
        public Date getReserveDate() {
            return reserveDate;
        }

        public void setReserveDate(Date reserveDate) {
            this.reserveDate = reserveDate;
        }
        public Date getPickupDate() {
            return pickupDate;
        }

        public void setPickupDate(Date pickupDate) {
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
        public Long getPayHistoryId() {
            return payHistoryId;
        }

        public void setPayHistoryId(Long payHistoryId) {
            this.payHistoryId = payHistoryId;
        }
        public String getPayHistoryStatus() {
            return payHistoryStatus;
        }

        public void setPayHistoryStatus(String payHistoryStatus) {
            this.payHistoryStatus = payHistoryStatus;
        }
        public String getReserveStatus() {
            return reserveStatus;
        }

        public void setReserveStatus(String reserveStatus) {
            this.reserveStatus = reserveStatus;
        }

}