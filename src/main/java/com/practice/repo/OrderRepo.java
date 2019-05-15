package com.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Items;
import com.practice.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>{

}
