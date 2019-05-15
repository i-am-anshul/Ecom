package com.practice.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.Items;
import com.practice.repo.ItemRepo;

@Service
public class ItemService{

	@Autowired
	ItemRepo itemRepo;

	public void addItem(Items item) {
		itemRepo.save(item);
	}
	
	public ArrayList<Items> getAll() {
		ArrayList <Items> item = new ArrayList<Items>();
		item = (ArrayList<Items>) itemRepo.findAll();
		return item;
		
	}
	
	
	public Optional<Items> getItemById(int id) {
		//Items item = new Items();
		
		Optional<Items> item = itemRepo.findById(id);
		return item;	
	}
	
	
	public Items updateItem(Items item) {
		
		return itemRepo.save(item);
		
	}
	
	public void delItem(int id) {
		
		itemRepo.deleteById(id);
	}
	
	
}
