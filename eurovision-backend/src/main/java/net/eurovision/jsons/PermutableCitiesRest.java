package net.eurovision.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermutableCitiesRest {
    @JsonProperty("name")
    String name;
    @JsonProperty("matches")
    int matches;
    
    @JsonProperty("validWords")
    String validWords;
}