package net.eurovision.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CitiesRest {
    @JsonProperty("content")
    List<CitiesRest> content;
    
    @JsonProperty("totalPages")
    int totalPages;
    
    @JsonProperty("totalElements")
    int totalElements;
    
    @JsonProperty("last")
    boolean last;
    
    @JsonProperty("size")
    int size;
    
    @JsonProperty("number")
    int number;
}