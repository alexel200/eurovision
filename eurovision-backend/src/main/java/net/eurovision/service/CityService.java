package net.eurovision.service;

import net.eurovision.jsons.CityRest;
import net.eurovision.jsons.PermutableCitiesRest;
import org.springframework.data.domain.Page;

public interface CityService {
    Page<CityRest> queryByPage(int page, int size);

    PermutableCitiesRest findCityWithMostPermutations(int citiesWordLength);
}