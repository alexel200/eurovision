package net.eurovision.controller;

import lombok.extern.slf4j.Slf4j;
import net.eurovision.jsons.CityRest;
import net.eurovision.jsons.PermutableCitiesRest;
import net.eurovision.response.CitiesResponse;
import net.eurovision.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/cities")
public class CityController {
    @Autowired
    CityService cityService;
    
    @GetMapping("/queryByPage")
    public Page<CityRest> queryByPage(Pageable pageable){
        log.info("The request has been received " + pageable);
        
        return cityService.queryByPage(pageable);
    }

    @GetMapping("/permutations")
    public CitiesResponse<PermutableCitiesRest> findCityWithMostPermutations(@RequestParam int cityNameLength){
        return new CitiesResponse<>("Sucess", String.valueOf(HttpStatus.OK), "OK", cityService.findCityWithMostPermutations(cityNameLength) );
    }
    
}