package com.vk.shop.business.abstracts;

import com.vk.shop.entities.City;

import java.util.List;

public interface CityService {

    List<City> getAllCities();

    City getCityByName(String cityName);

    City save(City city);

}
