package com.alessandragodoy.config;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Configuration class for environment variables.
 * Utilizes the Dotenv library to load environment variables from a .env file.
 */
public class EnvConfig {
	private static final Dotenv dotenv = Dotenv.load();

	/**
	 * Retrieves the value of the specified environment variable.
	 *
	 * @param key the name of the environment variable
	 * @return the value of the environment variable, or null if not found
	 */
	public static String get(String key) {
		return dotenv.get(key);
	}
}
