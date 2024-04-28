package com.vk.shop.repositories;

import com.vk.shop.entities.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

    City findCityByCityName(String cityName);
}
