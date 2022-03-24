package com.tejaswiniShopee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejaswiniShopee.demo.entity.Address;
import com.tejaswiniShopee.demo.service.AddressService;

@RestController
@RequestMapping("api/address")//url

public class AddressController {
	@Autowired
	private AddressService addressService;
	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	@PostMapping
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		return new ResponseEntity<Address>
	(addressService.saveAddress(address),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Address> getAllAddress()
	{
		return addressService.getAllAddress();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Address>getAddressById(@PathVariable("id") long id){
		return new ResponseEntity<Address>(addressService.getAddressById(id), HttpStatus.OK);
	}
	
	@GetMapping("/addressByIds")
	public List<Address>
	getAddressByIds(@RequestParam(value="id") List<Long> id){
		return addressService.getAddressById(id);
	}
	
	/*@PutMapping("{id}")
	public ResponseEntity<Address>
	updateAddress(@PathVariable("id") long id, @RequestBody Address address){
		return new ResponseEntity<Address>(addressService.updateAddress(address,id),HttpStatus.OK);
	}*/
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteAddress(@PathVariable("id") long id){
		addressService.deleteAddress(id);
		return new ResponseEntity<String>("Address record deleted",HttpStatus.OK);
	}
	
	
	
	


}
