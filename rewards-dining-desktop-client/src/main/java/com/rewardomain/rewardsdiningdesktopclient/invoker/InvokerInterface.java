package com.rewardomain.rewardsdiningdesktopclient.invoker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.sun.jersey.api.client.ClientResponse;

public interface InvokerInterface<T> {

    public ClientResponse get(long number);

    public ClientResponse get();

    public ClientResponse post(T entity) throws JsonProcessingException;

    public ClientResponse put(T entity) throws JsonProcessingException;

}
