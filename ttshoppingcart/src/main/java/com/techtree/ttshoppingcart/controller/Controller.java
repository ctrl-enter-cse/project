package com.techtree.ttshoppingcart.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techtree.ttshoppingcart.model.ObjecToExcel;
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
	
	@PostMapping("/placeorder")
	public ResponseEntity<Object> placeorder( @RequestBody OrderBean data ){
		return service.placeOrder(data);	
	}
	
	
	@GetMapping("/gettrans")
	public ResponseEntity<InputStreamResource> excelreport() throws IOException {
		 
		 List<Object[]> list=(List<Object[]>) service.gettranscation();
				 ByteArrayInputStream in = ObjecToExcel.objectoExcel(list);
				 HttpHeaders headers = new HttpHeaders();
				 headers.add("Content-Disposition","attachment; filename=transcation.xlsx" );
				 return ResponseEntity
				 .ok()
				 .headers(headers)
				 .body(new InputStreamResource(in));
		
	}
	
		
//		
//		return new ResponseEntity<Object>(service.gettranscation(), HttpStatus.OK);
//	}
}
