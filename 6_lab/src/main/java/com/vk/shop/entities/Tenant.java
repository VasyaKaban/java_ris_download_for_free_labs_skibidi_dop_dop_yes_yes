package com.vk.shop.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "tenants")
public class Tenant extends User{

    public Image profilePicture;

    public List<Visit> visitedHouses = new ArrayList<>();

    public List<House> ownHouses = new ArrayList<>();
    public Tenant() { }
}
