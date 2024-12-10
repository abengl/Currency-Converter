package com.alessandragodoy;

import com.alessandragodoy.exception.InvalidInputException;
import com.alessandragodoy.integration.RequestExchangeClient;
import com.alessandragodoy.model.Exchange;

import java.util.Scanner;
import java.util.logging.Logger;

public class CurrencyDriver {
	private static final Logger logger = Logger.getLogger(CurrencyDriver.class.getName());

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RequestExchangeClient request = new
				RequestExchangeClient();
		String baseCode = "";
		String targetCode = "";
		double amount = 0;

		try {
			System.out.println("Enter the base currency country code (e.g. USD): ");
			baseCode = validateCodeInput(in);

			System.out.println("Enter the target currency country code (e.g. PEN): ");
			targetCode = validateCodeInput(in);

			System.out.println("Enter the amount to exchange: ");
			amount = validateAmount(in);
			Exchange exchange = request.requestExchange(baseCode, targetCode);
			logger.info("exchange rate: " + exchange.conversion_rate());

			double exchangeResult = exchange.conversion_rate() * amount;

			System.out.printf("The exchange of %.2f %s results in %.2f %s%n", amount, baseCode,
					exchangeResult, targetCode);

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
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

	static double validateAmount(Scanner in) {
		double amount = in.nextDouble();
		if (amount <= 0) {
			throw new InvalidInputException("The amount must be a positive number greater than zero.");
		}
		return amount;
	}
}