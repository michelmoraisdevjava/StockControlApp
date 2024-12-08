package br.com.stock.exception;

public class ProductNotFoundException extends StockException{
	
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String name) {
		super("Product '" + name + "' not found in stock.");
	}

}
