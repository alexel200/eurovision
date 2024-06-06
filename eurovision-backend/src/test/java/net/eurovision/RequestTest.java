package net.eurovision;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.eurovision.jsons.CityRest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCitiesPageable() throws Exception {
        int page = 0;
        int size = 10;
        int totalExpectedCities = 332;
        
        Pageable pageable = PageRequest.of(page, size);
        
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/cities/queryByPage")
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size)))
                .andExpect(status().isOk())
                .andReturn();
        
        String responseJson = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        
        Page<CityRest> responsePage = objectMapper.readValue(responseJson, new TypeReference<Page<CityRest>>() {});
        
        assertEquals(responsePage.getTotalElements(), totalExpectedCities);
        assertEquals(responsePage.getContent().size(), size);
    }
    
}