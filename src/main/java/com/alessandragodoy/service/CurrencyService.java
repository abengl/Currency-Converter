package com.alessandragodoy.service;

import com.alessandragodoy.integration.ExchangeClient;
import com.alessandragodoy.utility.InputValidator;

import java.util.Map;
import java.util.Scanner;

/**
 * Service class for handling currency conversion operations.
 */
public class CurrencyService {
	private final ExchangeClient exchangeClient;
	private final InputValidator validator = new InputValidator();
	private final Map<Integer, String[]> conversionMap = Map.of(
			1, new String[]{"USD", "PEN"},
			2, new String[]{"PEN", "USD"},
			3, new String[]{"USD", "EUR"},
			4, new String[]{"EUR", "USD"},
			5, new String[]{"PEN", "EUR"});

	public CurrencyService(ExchangeClient exchangeClient) {
		this.exchangeClient = exchangeClient;
	}

	/**
	 * Converts the given amount from one currency to another based on the selected option.
	 *
	 * @param option  the conversion option selected by the user
	 * @param amount  the amount of currency to convert
	 * @param scanner the scanner object for user input
	 */
	public void convert(int option, double amount, Scanner scanner) {
		String baseCode;
		String targetCode;

		if (option == 6) {
			System.out.print("Enter the base currency code (e.g. USD): ");
			baseCode = validator.validateCodeInput(scanner);

			System.out.print("Enter the target currency code (e.g. PEN): ");
			targetCode = validator.validateCodeInput(scanner);
		} else if (conversionMap.containsKey(option)) {
			String[] codes = conversionMap.get(option);
			baseCode = codes[0];
			targetCode = codes[1];
		} else {
			System.out.println("Invalid option, please try again.");
			return;
		}

		double rate = exchangeClient.requestExchange(baseCode, targetCode).conversion_rate();
		double result = rate * amount;

		System.out.printf(">>> The exchange of %.2f %s is %.2f %s <<<%n", amount, baseCode, result, targetCode);
	}

}
