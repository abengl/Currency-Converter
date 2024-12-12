package com.alessandragodoy.integration;

import com.alessandragodoy.config.EnvConfig;
import com.alessandragodoy.exception.ClientRequestException;
import com.alessandragodoy.model.ErrorResponse;
import com.alessandragodoy.model.Exchange;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Implementation of the ExchangeClient interface to request exchange rates.
 */
public class ExchangeClientImpl implements  ExchangeClient{
	@Override
	public Exchange requestExchange(String baseCode, String targetCode) {
		String url = EnvConfig.get("API_URL_BASE") + "/" + baseCode + "/" + targetCode;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(URI.create(url))
				.build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			Gson gson = new Gson();
			if (response.statusCode() != 200) {
				throw new ClientRequestException("There was a client error '" + gson.fromJson(response.body(),
						ErrorResponse.class).errorType() + "'. Please, verify and try again.");
			}

			return gson.fromJson(response.body(), Exchange.class);

		} catch (IOException | InterruptedException e) {
			throw new ClientRequestException(e.getMessage());
		}
	}
}
