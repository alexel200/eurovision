package net.eurovision.service.impl;

import net.eurovision.entity.City;
import net.eurovision.repository.CityRepository;
import net.eurovision.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;


    @Override
    public Page<City> queryByPage(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }
}