package com.rewardomain.rewardsdiningdesktopclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rewardomain.rewardsdiningdesktopclient.decoder.Response;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;

import java.util.List;

public interface IBeneficeRestaurantService {
    public DefaultResponse createRestaurant(Restaurant restaurant) throws JsonMappingException, JsonProcessingException;
    public List<Restaurant> getRestaurants() throws JsonMappingException, JsonProcessingException;
    public Restaurant getRestaurant(long number) throws JsonMappingException, JsonProcessingException;
    public DefaultResponse updateRestaurant(Restaurant restaurant) throws JsonMappingException, JsonProcessingException;
}
