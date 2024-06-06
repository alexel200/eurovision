package net.eurovision;


import net.eurovision.repositories.CityRepository;
import net.eurovision.repositories.WordRepository;
import net.eurovision.service.impl.CityServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityServiceImplTest {

    @MockBean
    private CityRepository cityRepository;
    
    @MockBean
    private WordRepository wordRepository;
    
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