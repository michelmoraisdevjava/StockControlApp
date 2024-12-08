package br.com.stock.exception;

public class InvalidOperationException extends StockException{
	
	private static final long serialVersionUID = 1L;

	public InvalidOperationException(String message) {
		super(message);
	}

}
