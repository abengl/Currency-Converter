package com.alessandragodoy.model;

import com.google.gson.annotations.SerializedName;

public record ErrorResponse(@SerializedName("error-type") String errorType) {
}
