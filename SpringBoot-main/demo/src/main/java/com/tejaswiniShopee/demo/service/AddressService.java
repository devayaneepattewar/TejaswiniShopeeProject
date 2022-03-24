package com.tejaswiniShopee.demo.service;

import java.util.List;

import com.tejaswiniShopee.demo.entity.Address;

public interface AddressService {

	List<Address> getAllAddress();

	com.tejaswiniShopee.demo.entity.Address saveAddress(com.tejaswiniShopee.demo.entity.Address address);

	
	List<Address> getAddressById(List<Long> id);

	Address updateAddress(Address address, long id);

	void deleteAddress(long id);

	Address getAddressById(long id);

	
	Address getAddressById(Long id);

	
}
