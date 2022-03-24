package com.tejaswiniShopee.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tejaswiniShopee.demo.entity.Product;
import com.tejaswiniShopee.demo.exception.ResourceNotFoundException;
import com.tejaswiniShopee.demo.repository.ProductRepository;
import com.tejaswiniShopee.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	@Override
	public List<Product>getAllProduct(){
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(long id) {
		Optional<Product> product = 
				productRepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			throw new ResourceNotFoundException("Product","Id",id);
		}
	}
	@Override
	public Product updateProduct(Product product,long id) {
		Product pro = new Product();
		try {
			pro=productRepository.findById(id).orElseThrow(
					()-> new 
					ResourceNotFoundException("Product","Id",id));
		}catch(ResourceNotFoundException e) {
			e.printStackTrace();
		}
		pro.setProductName(product.getProductName());
		pro.setCategory(product.getCategory());
		pro.setPrice(product.getPrice());
		pro.setQuantity(product.getQuantity());
		
		productRepository.save(pro);
		return pro;
	}

	
}
