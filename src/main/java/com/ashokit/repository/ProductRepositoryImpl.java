package com.ashokit.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashokit.util.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String insertProduct(Product product) {
		String insertQuery = "INSERT INTO product (pid,productName,price) VALUE(?,?,?)";
		int update = jdbcTemplate.update(insertQuery, new Object[] { product.getPid(), product.getProductName(), product.getPrice() });
		
		if(update==1) {
			return " CSV Data Read Successfully..!!";
		}else {
			return " Failed to read Data From CSV.please try once again !!";
		}
		
	}
}
