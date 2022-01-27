package com.order.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.order.service.enums.OrderStatus;
import com.order.service.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Column(name = "product_id")
	private int productId;
	
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "price")
	private int price;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "quantity")
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	private OrderStatus orderStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus;

}
