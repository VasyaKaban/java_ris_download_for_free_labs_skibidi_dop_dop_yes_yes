package com.vk.shop.controllers;

import com.vk.shop.business.abstracts.UserService;
import com.vk.shop.entities.House;
import com.vk.shop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getByEmail/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }

    @GetMapping("getById/{userId}")
    public User findUserById(@PathVariable String userId) {
        return userService.findUserById(userId);
    }

    @PostMapping("/addFavorite/{userId}")
    public void addHouseToFavorites(@PathVariable String userId, @RequestBody House house) {
        userService.addHouseToFavorites(userId, house);
    }

    @PostMapping("/removeFavorite/{userId}")
    public void removeHouseFromFavorites(@PathVariable String userId, @RequestBody House house) {
        userService.removeHouseFromFavorites(userId, house);
    }
}
