package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.custom.UserOrderData;
import com.example.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("""
			SELECT o.id as orderId, o.quantity as quantity,o.totalPrice as totalPrice, o.user.id as userId,
			       u.name as name, u.surname as surname, u.age as age 
			FROM User u LEFT OUTER JOIN Order o ON u.id= o.user.id
			WHERE o.user.id IN (:userIds)
			""")
	List<UserOrderData> findUserAndOrderData(@Param("userIds") List<Integer> userIds);

}
