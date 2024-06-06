package net.eurovision.service;

import net.eurovision.jsons.CityRest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<CityRest> queryByPage(Pageable pageable);

    String findCityWithMostPermutations(int citiesWordLength);
}