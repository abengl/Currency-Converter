package com.alessandragodoy;

import com.alessandragodoy.config.EnvConfig;
import com.alessandragodoy.model.Exchange;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.logging.Logger;

public class CurrencyDriver {
	private static final Logger logger = Logger.getLogger(CurrencyDriver.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the base currency country code (e.g. USD): ");
		String baseCode = in.nextLine().trim();

		System.out.println("Enter the target currency country code (e.g. PEN): ");
		String targetCode = in.nextLine().trim();

		System.out.println("Enter the dollar amount to exchange: ");
		Double amount = in.nextDouble();

		String url = EnvConfig.get("API_URL_BASE") + "/" + baseCode + "/" + targetCode;

		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest
					.newBuilder()
					.uri(URI.create(url))
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			String jsonResponse = response.body();
			Exchange operation = new Gson().fromJson(jsonResponse, Exchange.class);
			logger.info("exchange rate: " + operation.conversion_rate());

			double exchange = operation.conversion_rate() * amount;

			System.out.printf("The exchange of %.2f %s results in %.2f %s%n", amount, baseCode,
					exchange, targetCode);
			logger.info("Successful operation.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			logger.warning("Invalid operation.");
		}
	}
}