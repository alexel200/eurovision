package net.eurovision.controller;

import net.eurovision.entity.City;
import net.eurovision.jsons.CitiesRest;
import net.eurovision.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/cities")
public class CityController {
    @Autowired
    CityService cityService;
    
    @GetMapping("/queryByPage")
    public Page<City> queryByPage(Pageable pageable){
        
        return cityService.queryByPage(pageable);
    }
    
}