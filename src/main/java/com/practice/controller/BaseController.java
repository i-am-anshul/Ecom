package com.practice.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.model.Items;
import com.practice.model.Orders;
import com.practice.repo.ItemRepo;
import com.practice.service.ItemService;
import com.practice.service.OrderService;

@RestController
public class BaseController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {

		return "Greetings from Anshul";
	}

	@RequestMapping(value = "/addItem", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public String addItem(@RequestBody Items item) {
		itemService.addItem(item);
		String status = "SUCCESS";
		return status;

	}

	@GetMapping("/showItems")
	public ArrayList<Items> showItems() {
		ArrayList<Items> item = new ArrayList<Items>();
		item = itemService.getAll();
		return item;
	}

	@GetMapping("/showItemsById/{id}")
	public Optional<Items> getItem(@PathVariable("id") int id) {

		Optional<Items> item = itemService.getItemById(id);
		if (!item.isPresent())
			try {
				throw new Exception("id not found-" + id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return item;

	}

	@DeleteMapping("/deleteItemById/{id}")
	public String deleteStudent(@PathVariable("id") int id) {

		itemService.delItem(id);

		return "Success";

	}

	@PostMapping("/updateItem")
	public String createItem(@RequestBody Items item) {
		itemService.updateItem(item);

		return "SUCCESS";
	}

	@RequestMapping(value = "/addOrder", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public String addOrder(@RequestBody Orders order) {
		int itemId = order.getItemId();
		int orderQuant = order.getOrderQuantity();
		Optional<Items> item = itemService.getItemById(itemId);
		if (!item.isPresent())
			return "Item not found";
		else {
			Items item1 = item.get();
			
			int itemQuant = item1.getItemQuantity();	
			if (itemQuant < orderQuant) {
				return "Quantity not available";
			}
			else 
			{
				itemQuant -= orderQuant;
				item1.setItemQuantity(itemQuant);
				int totalPrice = (int)item1.getItemPrice() * itemQuant;
				order.setTotalPrice(totalPrice);
				try
				{
					
					itemService.updateItem(item1);
					
					orderService.addOrder(order);
					return "Order Placed";
				}
				catch(Exception e)
				{
					return("Error");
				}
				
			}

		}
	}
	
	
	@GetMapping("/showOrders")
	public ArrayList<Orders> showOrders() {
		ArrayList<Orders> order = new ArrayList<Orders>();
		order = orderService.getOrders();
		return order;
	}
	
	@GetMapping("/showOrdersById/{id}")
	public Optional<Orders> getOrdersById(@PathVariable("id") int id) {

		Optional<Orders> order = orderService.getOrderById(id);
		if (!order.isPresent())
			try {
				throw new Exception("id not found-" + id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return order;

	}

}
