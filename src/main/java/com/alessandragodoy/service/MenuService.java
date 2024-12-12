package com.alessandragodoy.service;

import com.alessandragodoy.exception.ClientRequestException;
import com.alessandragodoy.exception.InvalidInputException;
import com.alessandragodoy.utility.InputValidator;

import java.util.Scanner;

/**
 * Service class for displaying the menu and handling user interactions.
 */
public class MenuService {
	private final Scanner scanner = new Scanner(System.in);
	private final InputValidator validator = new InputValidator();

	/**
	 * Runs the menu service, displaying the menu and handling user interactions.
	 *
	 * @param currencyService the currency service to use for conversions
	 * @throws InvalidInputException  if the user input is invalid
	 * @throws ClientRequestException if there is an error with the client request
	 */
	public void run(CurrencyService currencyService) {
		int option;
		do {
			displayMenu();
			try {
				option = validator.validateOption(scanner);
				if (option == 7) break;

				System.out.print("Enter the AMOUNT to exchange: ");
				double amount = validator.validateAmount(scanner);

				currencyService.convert(option, amount, scanner);
			} catch (InvalidInputException | ClientRequestException e) {
				System.out.println("Error>> " + e.getMessage());
				scanner.nextLine();
			} catch (Exception e) {
				System.out.print("An unexpected error occurred. " + e.getMessage());
				scanner.nextLine();
			}
		} while (true);
	}

	/**
	 * Displays the menu options for currency conversion.
	 */
	private void displayMenu() {
		System.out.println("\n********** Welcome to the currency converter **********");
		System.out.println("1) USD to PEN");
		System.out.println("2) PEN to USD");
		System.out.println("3) USD to EUR");
		System.out.println("4) EUR to USD");
		System.out.println("5) PEN to EUR");
		System.out.println("6) CUSTOM CONVERSION");
		System.out.println("7) EXIT");
		System.out.print("Select the OPTION to start the conversion: ");
	}
}
