package com.alessandragodoy.model;

/**
 * Represents an exchange rate between two currencies.
 *
 * @param base_code      the base currency code
 * @param target_code    the target currency code
 * @param conversion_rate the conversion rate from base to target currency
 */
public record Exchange(String base_code, String target_code, double conversion_rate) {
}
