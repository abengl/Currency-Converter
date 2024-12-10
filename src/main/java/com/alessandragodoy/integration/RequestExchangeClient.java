package com.alessandragodoy.integration;

import com.alessandragodoy.config.EnvConfig;
import com.alessandragodoy.exception.ClientRequestException;
import com.alessandragodoy.model.Exchange;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestExchangeClient {
	public Exchange requestExchange(String baseCode, String targetCode) {
		String url = EnvConfig.get("API_URL_BASE") + "/" + baseCode + "/" + targetCode;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(URI.create(url))
				.build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() != 200) {
				throw new ClientRequestException("There was a client error.");
			}

			return new Gson().fromJson(response.body(), Exchange.class);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
