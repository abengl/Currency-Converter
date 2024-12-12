package com.alessandragodoy.integration;

import com.alessandragodoy.model.Exchange;

/**
 * Interface for requesting exchange rates.
 */
public interface ExchangeClient {

	/**
	 * Requests the exchange rate between two currencies.
	 *
	 * @param baseCode   the base currency code
	 * @param targetCode the target currency code
	 * @return the exchange rate information
	 */
	Exchange requestExchange(String baseCode, String targetCode);
}
