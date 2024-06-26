package com.vk.shop.controllers;

import com.vk.shop.business.abstracts.CityService;
import com.vk.shop.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities/")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("getall")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping("save")
    public City save(@RequestBody City city) {
        return cityService.save(city);
    }
}
