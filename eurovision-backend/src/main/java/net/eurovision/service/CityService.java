package net.eurovision.service;

import net.eurovision.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> queryByPage(Pageable pageable);
    
}