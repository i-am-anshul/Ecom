package com.practice.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.Orders;
import com.practice.repo.OrderRepo;

@Service
public class OrderService {
	
	
	@Autowired
	OrderRepo orderRepo;
	
	public void addOrder(Orders order) {
		orderRepo.save(order);
	}
	
	public ArrayList<Orders> getOrders() {
		ArrayList <Orders> order = new ArrayList<Orders>();
		order = (ArrayList<Orders>) orderRepo.findAll();
		return order;
	}
	
	public Optional<Orders> getOrderById(int id) {
		Optional<Orders> order = orderRepo.findById(id);
		return order;
		
	}

}
