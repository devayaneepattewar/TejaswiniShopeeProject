package com.tejaswiniShopee.demo.service;

import java.util.List;

import com.tejaswiniShopee.demo.entity.Product;

public interface ProductService {

	Product updateProduct(Product product, long id);

	List<Product> getAllProduct();

	Product getProductById(long id);

	Product saveProduct(Product product);

}
