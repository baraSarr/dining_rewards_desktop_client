package com.rewardomain.rewardsdiningdesktopclient.decoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

public class ResponseDecoder<T> {
    private Response<T> response;
    private ObjectMapper decoder;

    public ResponseDecoder(ClientResponse clientResponse) throws JsonMappingException, JsonProcessingException {
        decoder = new ObjectMapper();
        setClientResponse (clientResponse);
    }

    public void setClientResponse (ClientResponse clientResponse) throws JsonMappingException, JsonProcessingException {
        String json = clientResponse.getEntity(String.class);
        response = decoder.readValue(json, Response.class);
    }
    public Response<T> getResponse() {
        return response;
    }
}
