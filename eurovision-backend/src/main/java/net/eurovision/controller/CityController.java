package net.eurovision.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.eurovision.jsons.CityRest;
import net.eurovision.jsons.PermutableCitiesRest;
import net.eurovision.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/cities")
@Tag(name="Cities")
public class CityController {
    @Autowired
    CityService cityService;
    
    @GetMapping("/queryByPage")
    public Page<CityRest> queryByPage(
                        @RequestParam(name="size", defaultValue = "10") int size,
                        @RequestParam(name="page", defaultValue = "0") int page
        ){
        log.info("The request has been received with this parameters page: " + page + ", size: " + size);
        
        return cityService.queryByPage(page, size);
    }

    @GetMapping("/permutations")
    public ResponseEntity<PermutableCitiesRest> findCityWithMostPermutations(@RequestParam int cityNameLength){
        
        return ResponseEntity.ok(cityService.findCityWithMostPermutations(cityNameLength));
    }
    
}