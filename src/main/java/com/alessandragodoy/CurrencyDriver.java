package com.alessandragodoy;

import com.alessandragodoy.integration.ExchangeClient;
import com.alessandragodoy.integration.ExchangeClientImpl;
import com.alessandragodoy.service.CurrencyService;
import com.alessandragodoy.service.MenuService;


public class CurrencyDriver {
	public static void main(String[] args) {
		ExchangeClient exchangeClient = new ExchangeClientImpl();
		CurrencyService currencyService = new CurrencyService(exchangeClient);
		MenuService menuService = new MenuService();

		menuService.run(currencyService);
	}
}