package net.eurovision;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAnswerWithOk() throws Exception {
        int page = 0;
        int size = 2;
        int totalExpectedCities = 2;
        
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cities/queryByPage")
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size))
                        .contentType("application/json")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(totalExpectedCities))
                .andExpect(jsonPath("$.content", hasSize(size)));
        

    }
    
}