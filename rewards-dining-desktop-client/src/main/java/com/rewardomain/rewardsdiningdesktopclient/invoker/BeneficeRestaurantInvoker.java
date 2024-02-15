package com.rewardomain.rewardsdiningdesktopclient.invoker;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.decoder.Encoder;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class BeneficeRestaurantInvoker implements InvokerInterface<Restaurant> {

    private Client client;
    private String uri;

    public BeneficeRestaurantInvoker(String uri) {
        this.client = Client.create();
        this.uri = uri;
    }

    @Override
    public ClientResponse get(long number) {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/" + number);
        return get(webResource);
    }

    @Override
    public ClientResponse get() {
        WebResource webResource = client.resource(uri);
        return get(webResource);
    }

    @Override
    public ClientResponse post(Restaurant entity) throws JsonProcessingException {
        WebResource webResource = client.resource(uri);
        webResource = addQueryParam(entity, webResource);
        Builder builder = getBuilder (webResource);
        String jsonInput = Encoder.toJson(entity);

        ClientResponse clientResponse = builder.post(ClientResponse.class, jsonInput);

        return clientResponse;
    }

    @Override
    public ClientResponse put(Restaurant entity) throws JsonProcessingException {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/" + String.valueOf(entity.getNumber()) + "/" + entity.getAvailability());
        Builder builder = getBuilder (webResource);

        ClientResponse clientResponse = builder.put(ClientResponse.class);

        return clientResponse;
    }

    private ClientResponse get (WebResource webResource) {

        Builder builder = getBuilder (webResource);
        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return clientResponse;
    }

    private Builder getBuilder (WebResource webResource) {
        Builder builder = webResource.accept(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON);
        return builder;
    }

    private WebResource addQueryParam (Restaurant entity, WebResource webResource) {

        webResource = webResource.queryParam("id", String.valueOf(entity.getId()));
        webResource = webResource.queryParam("number", String.valueOf(entity.getNumber()));
        webResource = webResource.queryParam("name", entity.getName());
        webResource = webResource.queryParam("percentage", String.valueOf(entity.getPercentage()));
        webResource = webResource.queryParam("availability", entity.getAvailability());
        return webResource;
    }


}
