package com.techtree.ttshoppingcart.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtree.ttshoppingcart.model.orders;

public interface OrderRepo extends JpaRepository<orders, Integer> {

	
	
	
}
