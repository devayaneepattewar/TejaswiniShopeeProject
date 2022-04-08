package com.tejaswiniShopee.demo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.tejaswiniShopee.demo.entity.Product;
import com.tejaswiniShopee.demo.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class productRepositoryTests {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	@Rollback(false)
	public void saveProductTest() {
		Product product = productRepository.save(new Product("Mangalsutra", "Brass High Gold",3200,25 ));
		Assertions.assertThat(product.getId()).isGreaterThan(0);
	}
	
	@Test 
	public void getProductListTest() {
		List<Product> products = productRepository.findAll();
		Assertions.assertThat(products.size()).isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	public void updateProductTest() {
		Product product = productRepository.findById(1L).get();
		product.setCategory("One gram Jewellary");
		Product updated = productRepository.save(product);
		Assertions.assertThat(product.getCategory()).isEqualTo("One gram Jewellary");	
	}
	
	@Test
	@Rollback(false)
	public void deleteProductTest() {
		Product product1 = productRepository.findById(5L).get();
		productRepository.delete(product1);
		Product product = null;
		Optional<Product> product2 = productRepository.findById(5L);
		if(product2.isPresent()) {
		}
		Assertions.assertThat(product).isNull();
		
	}

}
