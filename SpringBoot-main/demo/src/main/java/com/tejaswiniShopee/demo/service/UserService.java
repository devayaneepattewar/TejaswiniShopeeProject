package com.tejaswiniShopee.demo.service;

import java.util.Optional;

import com.tejaswiniShopee.demo.entity.User;

public interface UserService {
	public Optional<User> findUserByUserName(String userName);
	   


}
