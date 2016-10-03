package types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {

	@Id @GeneratedValue 
	
	//@Column(name = "Order_number")
	private int Order_number;

	@Column(name = "product_code")
	private String product_code;

	@Column(name = "price")
	private String price;

	@ManyToOne
	@JoinColumn(name="order_number")
	OrderHeader header;
	
	/*public int getOrder_number() {
		return Order_number;
	}

	public void setOrder_number(int order_number) {
		Order_number = order_number;
	}*/
	
	

	public String getProduct_code() {
		return product_code;
	}

	@Override
	public String toString() {
		return "OrderDetails [Product_code=" + product_code + ", price=" + price
				+ "]";
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
