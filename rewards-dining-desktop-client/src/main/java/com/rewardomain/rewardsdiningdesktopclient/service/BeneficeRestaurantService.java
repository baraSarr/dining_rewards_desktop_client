package com.rewardomain.rewardsdiningdesktopclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.rewardomain.rewardsdiningdesktopclient.invoker.BeneficeRestaurantInvoker;
import com.rewardomain.rewardsdiningdesktopclient.invoker.InvokerInterface;
import com.sun.jersey.api.client.ClientResponse;

import java.util.List;

public class BeneficeRestaurantService implements IBeneficeRestaurantService{

    private final InvokerInterface<Restaurant> invoker;
    private ObjectMapper decoder;

    public static final String RESOURCE_URI = "http://localhost:8765/benefit-restaurant/merchants";

    public BeneficeRestaurantService() {
        invoker = new BeneficeRestaurantInvoker(RESOURCE_URI);
        decoder = new ObjectMapper();
    }

    @Override
    public DefaultResponse createRestaurant(Restaurant restaurant) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.post(restaurant);
        String json = clientResponse.getEntity(String.class);
        DefaultResponse response = decoder.readValue(json, DefaultResponse.class);
        return response;
    }

    @Override
    public List<Restaurant> getRestaurants() throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.get();
        String json = clientResponse.getEntity(String.class);
        List<Restaurant> response = decoder.readValue(json, new TypeReference<List<Restaurant>>(){});
        return response;
    }

    @Override
    public Restaurant getRestaurant(long number) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.get(number);
        String json = clientResponse.getEntity(String.class);
        Restaurant response = decoder.readValue(json, Restaurant.class);
        return response;
    }

    @Override
    public DefaultResponse updateRestaurant(Restaurant restaurant) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.put(restaurant);
        String json = clientResponse.getEntity(String.class);
        DefaultResponse response = decoder.readValue(json, DefaultResponse.class);
        return response;
    }
}
