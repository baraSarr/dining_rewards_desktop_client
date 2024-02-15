package com.rewardomain.rewardsdiningdesktopclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.Confirmation;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;
import com.rewardomain.rewardsdiningdesktopclient.entity.Dining;
import com.rewardomain.rewardsdiningdesktopclient.entity.Reward;

import java.util.List;

public interface IRewardManagerService {
    List<Reward> getRewards() throws JsonMappingException, JsonProcessingException;
    DefaultResponse distribute(String cardNumber, long rewardNumber) throws JsonMappingException, JsonProcessingException;
    Confirmation createReward(Dining dining) throws JsonMappingException, JsonProcessingException;
}
