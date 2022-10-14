package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.dto.UserInput;
import com.example.entity.Order;
import com.example.entity.User;
import com.example.service.OrderService;
import com.example.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	
	private UserService userService;
	private OrderService orderService;
	
	@QueryMapping
	public List<User> users(){
		return userService.getAllUsers();
	}
	
	@BatchMapping
	public Map<User,List<Order>> orders(List<User> users){
		return orderService.getCustomersOrder(users);
	}

	@QueryMapping
	public User getUserById(@Argument @NotNull Integer id) {
		return userService.getUserById(id);
	}
	
	@MutationMapping
	public User newUser(@Argument @Valid UserInput user) {
		return userService.saveUser(user);
	}
	
	@MutationMapping
	public User updateUser(@Argument @Valid UserInput user) {
		return userService.updateUser(user);
	}
	
	@MutationMapping
	public Integer deleteUser(@Argument @NotNull @Positive Integer id) {
		return userService.deleteUser(id);
	}

}
