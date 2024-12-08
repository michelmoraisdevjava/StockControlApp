package br.com.stock.exception;

public class InsufficientStockException extends StockException{
	
	private static final long serialVersionUID = 1L;

	public InsufficientStockException(String name, int quantityAvailable, int quantityRequested) {
		super("Insufficient stock for the product '" +  name + "'. Available: "
				+ quantityAvailable + ", requested: " + quantityRequested + ".");
	}

}
