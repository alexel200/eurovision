package net.eurovision.service.impl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({MockitoExtension.class})
public class CityServiceImplTest{
    
    @InjectMocks
    private CityServiceImpl cityService;
    
    @Test
    public void testPermuteWord(){
        String cityName = "Houston";
        
        List<String> result =  cityService.permute(cityName.toLowerCase());
        result = result.stream().filter(word -> word.length() >= 5).distinct().toList();

        assertTrue(result.size() > 5040);
        assertTrue(result.contains("shout"));
        assertTrue(result.contains("tonus"));
    }
}