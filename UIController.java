package com.tejaswiniShopee.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tejaswiniShopee.demo.entity.Customer;
import com.tejaswiniShopee.demo.service.AddressService;
import com.tejaswiniShopee.demo.service.CustomerService;
import com.tejaswiniShopee.demo.service.OrderService;
import com.tejaswiniShopee.demo.service.ProductService;

@Controller

public class UIController {
	private CustomerService customerService;
	private ProductService productService;
	private AddressService addressService;
	private OrderService orderService;

	
	@Autowired
	public UIController(CustomerService customerService,ProductService productService,AddressService addressService,OrderService orderService) {
		super();
		this.customerService=customerService;
		this.productService=productService;
		this.addressService=addressService;
		this.orderService=orderService;
		
	}
	
	@GetMapping("/")
	String index() {
		return "index";//index.html
	}

//Customer
	@GetMapping("/registration")
	public String custRegistrationForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	/*@GetMapping("/registration")
	public String custRegistrationForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}*/
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Validated Customer customer,Errors errors,Model model) {
		if(null != errors && errors.getErrorCount()>0)
			return "redirect:/";
		else {
			customerService.saveCustomer(customer);
			List<Customer> customer1 = customerService.getAllCustomer();
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getCustomers";
		
	}
	
	@GetMapping("/customer/getCustomers")
	public String getAllCustomer(Model model) {
		List<Customer> customer1 = customerService.getAllCustomer();
		model.addAttribute("customer", customer1);
		return "list-customer";
	}
	
	
	
	
}
