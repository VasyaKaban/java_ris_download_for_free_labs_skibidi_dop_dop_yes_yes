package com.vk.shop.business.abstracts;

import com.vk.shop.entities.House;
import com.vk.shop.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User addUser(User user);

    User findUserByEmail(String email);

    User findUserById(String userId);

    void addHouseToFavorites(String userId, House house);

    void removeHouseFromFavorites(String userId, House house);
}
