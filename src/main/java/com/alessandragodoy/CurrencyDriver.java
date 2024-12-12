package com.alessandragodoy;

import com.alessandragodoy.exception.InvalidInputException;
import com.alessandragodoy.integration.RequestExchangeClient;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyDriver {


	public static void main(String[] args) {
		RequestExchangeClient request = new RequestExchangeClient();
		int option;
		double amount;

		try (Scanner in = new Scanner(System.in)) {
			while (true) {
				displayMenu();
				option = in.nextInt();
				in.nextLine();
				if (option == 7) {
					break;
				}

				System.out.println("Enter the AMOUNT to exchange: ");
				amount = validateAmount(in);

				exchange(option, request, amount, in);
			}
		} catch (InvalidInputException | InputMismatchException e) {
			System.out.println("There was an error: " + e.getMessage());
		}
	}

	static void displayMenu() {
		System.out.println("********** Welcome to the currency converter **********");
		System.out.println("1) AMERICAN DOLLAR (USD) --> PERUVIAN SOL (PEN)");
		System.out.println("2) PERUVIAN SOL (PEN) --> AMERICAN DOLLAR (USD)");
		System.out.println("3) AMERICAN DOLLAR (USD) --> EURO (EUR)");
		System.out.println("4) EURO (EUR) --> AMERICAN DOLLAR (USD)");
		System.out.println("5) PERUVIAN SOL (PEN) --> EURO (EUR)");
		System.out.println("6) CUSTOM CONVERSION");
		System.out.println("7) EXIT");
		System.out.println("Select the OPTION to start the conversion:");
	}

	static double validateAmount(Scanner in) {
		double amount = in.nextDouble();
		in.nextLine();
		if (amount <= 0) {
			throw new InvalidInputException("The amount must be a positive number greater than zero.");
		}
		return amount;
	}

	static void exchange(int option,
						 RequestExchangeClient request, double amount, Scanner in) {
		try {
			String baseCode;
			String targetCode;
			switch (option) {
				case 1:
					baseCode = "USD";
					targetCode = "PEN";
					break;
				case 2:
					baseCode = "PEN";
					targetCode = "USD";
					break;
				case 3:
					baseCode = "USD";
					targetCode = "EUR";
					break;
				case 4:
					baseCode = "EUR";
					targetCode = "USD";
					break;
				case 5:
					baseCode = "PEN";
					targetCode = "EUR";
					break;
				case 6:
					System.out.println("Enter the base currency country code (e.g. USD | KRW | JPY | CNY): ");
					baseCode = validateCodeInput(in);

					System.out.println("Enter the target currency country code (e.g. PEN | MXN | ARS | BRL): ");
					targetCode = validateCodeInput(in);
					break;
				default:
					System.out.println("It is not a valid option, please try again.");
					return;
			}

			double exchangeResult = request.requestExchange(baseCode, targetCode).conversion_rate() * amount;
			System.out.printf("*** The exchange of %.2f %s results in %.2f %s ***%n%n", amount, baseCode,
					exchangeResult, targetCode);

		} catch (InvalidInputException e) {
			System.out.println("There was an error: " + e.getMessage());
		}
	}

	static String validateCodeInput(Scanner in) {
		String countryCode = in.nextLine().trim();
		if (countryCode.isEmpty()) {
			throw new InvalidInputException("The country code is a required value.");
		}
		if (!countryCode.matches("[A-Za-z]{3}")) {
			throw new InvalidInputException("The country code must be 3 valid characters");
		}
		return countryCode.toUpperCase();
	}
}