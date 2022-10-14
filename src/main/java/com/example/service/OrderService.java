package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.custom.UserOrderData;
import com.example.entity.Order;
import com.example.entity.User;
import com.example.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

	private OrderRepository orderRepository;

	public Map<User, List<Order>> getCustomersOrder(List<User> users) {
		List<Integer> userIds =  users.stream().map(user-> user.getId()).toList();
		
		List<UserOrderData> userOrderData = orderRepository.findUserAndOrderData(userIds);
		
		Map<User, List<Order>> User_ListorderMap = userOrderData.stream()
				.collect(
						Collectors
								.groupingBy(
										userOrder -> User.builder().id(userOrder.getUserId()).name(userOrder.getName())
												.surname(userOrder.getSurname()).age(userOrder.getAge()).build(),
										Collectors.mapping(userOrder -> {

											Order order = null;
											if (userOrder.getQuantity() != null) {
												order = Order.builder().id(userOrder.getOrderId()).quantity(userOrder.getQuantity())
														.totalPrice(userOrder.getTotalPrice())
														.build();
											}
											return order;

										}, Collectors.toList())));
		
		return User_ListorderMap;
	}
	
}
