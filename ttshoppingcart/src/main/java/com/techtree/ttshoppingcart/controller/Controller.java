package com.techtree.ttshoppingcart.controller;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techtree.ttshoppingcart.model.OrderBean;
import com.techtree.ttshoppingcart.model.getDeatail;
import com.techtree.ttshoppingcart.service.impl.serviceimpl;

@org.springframework.stereotype.Controller
@RequestMapping("/ttshoppingcart")
public class Controller {
	
	@Autowired
	 private serviceimpl service;
	
	@GetMapping("/get")
	public ResponseEntity<Object> findall(){
		return service.get();
//		System.out.println(service.toString());
//		return service.toString();
	}
	
	@PostMapping("/getbyid")
	public ResponseEntity<Object> findbyid( @RequestBody getDeatail data ){
		return service.getbyId(data.getId(),data.getAmounttype()) ;
		
	}

	
//	@GetMapping("/pickobject")
//	public ResponseEntity<Object> pickobj() throws ParseException{
//		return service.pickobject();
//	}
	

	public ResponseEntity<Object> placeorder( @RequestBody OrderBean data ){
		return service.placeOrder(data);
		
	}
	
	
}
