package com.rewardomain.rewardsdiningdesktopclient.invoker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.Dining;
import com.sun.jersey.api.client.ClientResponse;

public interface IRewardManagerInvoker {
    public ClientResponse get();
    public ClientResponse get(String cardNumber, long rewardNumber);
    public ClientResponse post(Dining entity) throws JsonProcessingException;
}
