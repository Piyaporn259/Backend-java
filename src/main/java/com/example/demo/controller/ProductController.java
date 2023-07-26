package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.model.Product;


@RestController
public class ProductController {

	private List<Product> data = new ArrayList<Product>();
	
	@GetMapping("/product")
	public List<Product> getProducts() {
		return data;
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product body) 
	{
	   for(int i = 0; i < data.size(); i++) {
		   if(data.get(i).getproductId() == body.getproductId()){
			   return null;
		   }
	   }
	   data.add(body);
	   return body;
	}
	
	@GetMapping("/product/{productId}")
	public Product getProjectDetai(@PathVariable Integer productId) {
		
		for (int i = 0; i < data.size(); i++) {
			if (productId == data.get(i).getproductId()) {
				return data.get(i);
			}
		}
		
		return null;
	}
	@PutMapping("/product/{productId}")
	public Product updateProduct(@PathVariable Integer productId,@RequestBody Product body){
		
		for (int i = 0; i < data.size(); i++) {
			if (productId == data.get(i).getproductId()) {
				
				data.get(i).setproductName(body.getproductName());
				data.get(i).setproductPrice(body.getproductPrice());
				data.get(i).setproductAmount(body.getproductAmount());
				data.get(i).setproductDetail(body.getproductDetail());
				return data.get(i);
				
			}
		}
		return null;
	}

	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable Integer productId) {
		for (int i = 0; i < data.size(); i++) {
			if (productId  == data.get(i).getproductId()) {
				data.remove(i);
				return "delete sucess";
			}
		}
		
			return "delete sucess";
}
}
