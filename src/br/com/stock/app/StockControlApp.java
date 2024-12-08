package br.com.stock.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.stock.exception.InvalidOperationException;
import br.com.stock.exception.StockException;
import br.com.stock.model.Product;
import br.com.stock.service.Stock;

public class StockControlApp {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Stock stock = new Stock();

		System.out.print("Enter file full path: ");
		String filePath = sc.nextLine();

		try {
			stock.loadStock(filePath);
			System.out.println("Estoque carregado com sucesso!");
		} catch (IOException | InvalidOperationException e) {
			System.out.println("Error loading file: " + e.getMessage());
		}

		boolean exit = false;
		while (!exit) {
			System.out.println("\nMENU:");
			System.out.println("1. Consult Stock");
			System.out.println("2. Add to Stock");
			System.out.println("3. Register Sale");
			System.out.println("4. List Products");
			System.out.println("5. Save and Exit");
			System.out.print("Choose an option: ");

			int option = sc.nextInt();
			sc.nextLine();

			try {
				switch (option) {
				case 1 -> loadStock(stock, sc);
				case 2 -> addStock(stock, sc);
				case 3 -> registerSales(stock, sc);
				case 4 -> stock.listProducts();
				case 5 -> {
					stock.saveStock(filePath);
					exit = true;
					System.out.println("Stock saved successfully. Leaving...");
				}
				default -> System.out.println("Invalid option!");
				}
			} catch (StockException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("Error saving stock: " + e.getMessage());
			}
		}
		sc.close();

	}

	private static void loadStock(Stock stock, Scanner sc) {
		System.out.print("Enter the product name: ");
		String name = sc.nextLine();

		try {
			Product product = stock.consultProduct(name);
			System.out.println("Stock of " + name + ": " + product.getQuantity());
		} catch (StockException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addStock(Stock stock, Scanner sc) {
		System.out.print("Enter the product name: ");
		String name = sc.nextLine();
		System.out.println("Quantity to add: ");
		int quantity = sc.nextInt();
		sc.nextLine();

		try {
			stock.addStock(name, quantity);
			System.out.println("Stock updated successfully!");
		} catch (StockException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void registerSales(Stock stock, Scanner sc) {
		System.out.print("Enter the product name: ");
		String name = sc.nextLine();
		System.out.print("Enter the quantity sold: ");
		int quantity = sc.nextInt();
		sc.nextLine();

		try {
			stock.registerSales(name, quantity);
			System.out.println("Sale registered successfully!");
		} catch (StockException e) {
			System.out.println(e.getMessage());
		}
	}

}
