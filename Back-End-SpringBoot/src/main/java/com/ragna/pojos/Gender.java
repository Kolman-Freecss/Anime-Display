package com.ragna.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {

	@JsonProperty("Horror")
	HORROR,
	@JsonProperty("History")
	HISTORY,
	@JsonProperty("Action")
	ACTION
	
}
