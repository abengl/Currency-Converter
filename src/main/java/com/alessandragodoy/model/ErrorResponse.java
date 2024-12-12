package com.alessandragodoy.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents an error response from the API.
 *
 * @param errorType the type of error returned by the API
 */
public record ErrorResponse(@SerializedName("error-type") String errorType) {
}
