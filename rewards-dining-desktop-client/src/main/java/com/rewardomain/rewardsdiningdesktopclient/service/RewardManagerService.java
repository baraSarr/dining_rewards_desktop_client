package com.rewardomain.rewardsdiningdesktopclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rewardomain.rewardsdiningdesktopclient.entity.*;
import com.rewardomain.rewardsdiningdesktopclient.invoker.IRewardManagerInvoker;
import com.rewardomain.rewardsdiningdesktopclient.invoker.RewardManagerInvoker;
import com.sun.jersey.api.client.ClientResponse;

import java.util.List;

public class RewardManagerService implements IRewardManagerService{
    private IRewardManagerInvoker invoker;
    private ObjectMapper decoder;
    public static final String RESOURCE_URI = "http://localhost:8765/reward-manager";

    public RewardManagerService() {
        decoder = new ObjectMapper();
        invoker = new RewardManagerInvoker(RESOURCE_URI);
    }


    @Override
    public List<Reward> getRewards() throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.get();
        String json = clientResponse.getEntity(String.class);
        decoder.registerModule(new JavaTimeModule());
        List<Reward> response = decoder.readValue(json, new TypeReference<List<Reward>>(){});
        return response;
    }

    @Override
    public DefaultResponse distribute(String cardNumber, long rewardNumber) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.get(cardNumber, rewardNumber);
        String json = clientResponse.getEntity(String.class);
        DefaultResponse response = decoder.readValue(json, DefaultResponse.class);
        return response;
    }

    @Override
    public Confirmation createReward(Dining dining) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.post(dining);
        String json = clientResponse.getEntity(String.class);
        Confirmation response = decoder.readValue(json, Confirmation.class);
        return response;
    }
}
