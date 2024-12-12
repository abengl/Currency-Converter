package com.alessandragodoy.utility;

import com.alessandragodoy.exception.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Utility class for validating user input.
 */
public class InputValidator {

	/**
	 * Validates the amount entered by the user.
	 *
	 * @param scanner the scanner object for user input
	 * @return the validated amount
	 * @throws InvalidInputException if the input is not a valid number or is less than or equal to zero.
	 */
	public double validateAmount(Scanner scanner) {
		try {
			double amount = scanner.nextDouble();
			scanner.nextLine();
			if (amount <= 0) throw new InvalidInputException("The amount must be greater than zero.");
			return amount;
		} catch (InputMismatchException e) {
			throw new InvalidInputException("The amount must be a valid number.");
		}
	}

	/**
	 * Validates the option selected by the user.
	 *
	 * @param scanner the scanner object for user input
	 * @return the validated option
	 * @throws InvalidInputException if the input is not a valid number or is not between 1 and 7.
	 */
	public int validateOption(Scanner scanner) {
		try {
			int option = scanner.nextInt();
			scanner.nextLine();
			if (option < 1 || option > 7) throw new InvalidInputException("Invalid option selected.");
			return option;
		} catch (InputMismatchException e) {
			throw new InvalidInputException("The option must be a valid number between 1-7.");
		}
	}

	/**
	 * Validates the currency code entered by the user.
	 *
	 * @param scanner the scanner object for user input
	 * @return the validated currency code
	 * @throws InvalidInputException if the input is not a valid 3-letter currency code.
	 */
	public String validateCodeInput(Scanner scanner) {
		String code = scanner.nextLine().trim().toUpperCase();
		if (!code.matches("[A-Z]{3}")) throw new InvalidInputException("Currency code must be 3 letters.");
		return code;
	}
}
