package com.example.soulshelperbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameIgdbResponse {
    @JsonProperty("id")
    private int id;
    @JsonProperty("cover")
    private int coverId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("summary")
    private String summary;
}
