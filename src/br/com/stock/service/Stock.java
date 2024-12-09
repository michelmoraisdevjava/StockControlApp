package br.com.stock.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.stock.exception.InsufficientStockException;
import br.com.stock.exception.InvalidOperationException;
import br.com.stock.exception.ProductNotFoundException;
import br.com.stock.model.Product;

public class Stock {
	
	private final Map<String, Product> products = new HashMap<String, Product>();
	
	public synchronized void loadStock(String filePath) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				
				if(fields.length != 2) {
					throw new InvalidOperationException("Invalid format in CSV file.");
				}
				
				String name = fields[0].trim();
				int quantity;
				try {
					quantity = Integer.parseInt(fields[1].trim());
				} catch (NumberFormatException e) {
					throw new InvalidOperationException("Invalid quantity in CSV file.");
				}
				
				products.put(name, new Product(name, quantity));
				line = br.readLine();
			}
		}
	}
	
	public synchronized void saveStock(String filePath) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			for(Product product : products.values()) {
				bw.write(product.getName() + "," + product.getQuantity());
				bw.newLine();
			}
		}
	}
	
	public synchronized Product consultProduct(String name) {
		Product product = products.get(name);
		if(product == null) {
			throw new ProductNotFoundException(name);
		}
		return product;
	}
	
	public synchronized void addStock(String name, int quantity) {
		if(quantity < 0) {
			throw new InvalidOperationException("The amount to add cannot be negative.");
		}
		
		Product product = products.get(name);
		if(product == null) {
			product = new Product(name, quantity);
			products.put(name, product);
		} else {
			product.setQuantity(product.getQuantity() +  quantity);
		}
	}
	
	public synchronized boolean registerSales(String name, int quantity) {
		if(quantity <= 0) {
		throw new InvalidOperationException("The quantity to be sold must be greater than zero.");
		}
		
		Product product = products.get(name);
		if(product == null) {
			throw new ProductNotFoundException(name);
		}
		
		if(product.getQuantity() < quantity) {
			throw new InsufficientStockException(name, product.getQuantity(), quantity);
		}
		
		product.setQuantity(product.getQuantity() - quantity);
		return true;
	}
	
	public synchronized void removeProduct(String name) {
		if(!products.containsKey(name)) {
			throw new ProductNotFoundException(name);
		}
		
		products.remove(name);
		System.out.println("Product '" + name + "' removed from stock successfully!");
	}
	
	public synchronized void listProducts() {
		System.out.println("\nProducts in stock:");
		for(Product product : products.values()) {
			System.out.println(product);
		}
	}

}
