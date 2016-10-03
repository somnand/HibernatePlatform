package types;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_header")
public class OrderHeader {

	@Id
	@GeneratedValue
	@Column(name = "order_number")
	private int order_number;

	@Column(name = "total_order_value")
	private double order_value;

	@Column(name = "delivery_charge")
	private String delivery_charge;

	@Column(name = "order_time")
	private String order_time;
	
	@OneToMany(mappedBy="header",fetch=FetchType.EAGER)
	
	private List<OrderDetails> orderDetailList;

	public List<OrderDetails> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetails> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public int getOrder_number() {
		return order_number;
	}

	@Override
	public String toString() {
		return "OrderHeader [order_number=" + order_number + ", order_value=" + order_value + ", delivery_charge="
				+ delivery_charge + ", order_time=" + order_time;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public double getOrder_value() {
		return order_value;
	}

	public void setOrder_value(double order_value) {
		this.order_value = order_value;
	}

	public String getDelivery_charge() {
		return delivery_charge;
	}

	public void setDelivery_charge(String delivery_charge) {
		this.delivery_charge = delivery_charge;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

}
