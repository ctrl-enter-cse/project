package com.techtree.ttshoppingcart.service;


import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import com.techtree.ttshoppingcart.model.OrderBean;

public interface service {
	
	public ResponseEntity<Object>	get();
	
	public ResponseEntity<Object> getbyId(Integer id,String amounttype);

	
	public ResponseEntity<Object> pickobject() throws ParseException;
	
//	public ResponseEntity<Object> pickobject()
	public ResponseEntity<Object> placeOrder(OrderBean data);
}
