package com.ashokit.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.repository.ProductRepository;
import com.ashokit.util.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public String readCsvData() throws FileNotFoundException {
		
				String statusMessage="";
				// calling method which read csv data and insert to Database
			
				String fileName = "D:\\Study_Workspace\\AshokIT_Notes\\product.csv";

				Product p = new Product();

				BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
				String lineText = null;

				try {

					while ((lineText = lineReader.readLine()) != null) {
						String[] data = lineText.split(",");
						String pid = data[0];
						String productName = data[1];
						String price = data[2];

						p.setPid(Integer.parseInt(pid));
						p.setProductName(productName);
						p.setPrice(Double.parseDouble(price));

						System.out.println("===============" + p.getPid());
						System.out.println("===============" + p.getProductName());
						System.out.println("===============" + p.getPrice());

						statusMessage = productRepository.insertProduct(p);

					}
					lineReader.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		
		return statusMessage;
	}

}
