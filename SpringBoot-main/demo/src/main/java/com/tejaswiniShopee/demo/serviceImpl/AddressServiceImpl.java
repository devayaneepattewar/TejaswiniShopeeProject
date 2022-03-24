package com.tejaswiniShopee.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejaswiniShopee.demo.entity.Address;
import com.tejaswiniShopee.demo.exception.ResourceNotFoundException;
import com.tejaswiniShopee.demo.repository.AddressRepository;
import com.tejaswiniShopee.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
//@Autowired
private AddressRepository addressRepository;
	
	public AddressServiceImpl(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}
	
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	
	/*@Override
	public Address getAddressById(Long id) throws ResourceNotFoundException {
		Optional<Address> address = addressRepository.findById(id);
		if(address.isPresent()) {
			return address.get();
		}
		else {
			throw new ResourceNotFoundException("Address","Id",id);
		}
	}*/
	

	

	/*@Override
	public Address updateAddress(Address address, long id) {
		Address ads = new Address();
		try {
			ads = addressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address","Id",id));
		}catch(Exception e) {
			e.printStackTrace();
		}
		String fname = address.getFirstName();
		ads.setFirstName(fname);
		
		ads.setLastName(address.getLastName());
		ads.setEmail(ads.getEmail());
		
		addressRepository.save(ads);
		return ads;
	
	}*/

	/*@Override
	public Address getAddressById(long id) {
		Optional<Address>address = addressRepository.findById(id);
		if(address.isPresent()) {
			return address.get();
		}else {
			throw new ResourceNotFoundException("Address","Id",id);
		}
	}*/

	@Override
	public void deleteAddress(long id) {
		addressRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address","Id",id));
		addressRepository.deleteById(id);
	}

	
	
	

	@Override
	public List<Address> getAddressById(List<Long> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(Address address, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddressById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddressById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
