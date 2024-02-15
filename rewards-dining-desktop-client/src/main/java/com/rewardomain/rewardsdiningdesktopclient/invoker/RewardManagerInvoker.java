package com.rewardomain.rewardsdiningdesktopclient.invoker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.decoder.Encoder;
import com.rewardomain.rewardsdiningdesktopclient.entity.AccountContributionRequest;
import com.rewardomain.rewardsdiningdesktopclient.entity.Dining;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class RewardManagerInvoker implements IRewardManagerInvoker{

    private Client client;
    private String uri;

    public RewardManagerInvoker(String uri) {
        this.client = Client.create();
        this.uri = uri;
    }

    @Override
    public ClientResponse get() {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/rewards");
        return get(webResource);
    }

    @Override
    public ClientResponse get(String cardNumber, long rewardNumber) {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/distribute/"+cardNumber+"/reward/"+rewardNumber);
        return get(webResource);
    }

    @Override
    public ClientResponse post(Dining entity) throws JsonProcessingException {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/rewards");
        webResource = addQueryParam(entity, webResource);
        WebResource.Builder builder = getBuilder (webResource);
        String jsonInput = Encoder.toJson(entity);
        ClientResponse clientResponse = builder.post(ClientResponse.class, jsonInput);
        return clientResponse;
    }

    private ClientResponse get (WebResource webResource) {

        WebResource.Builder builder = getBuilder (webResource);
        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return clientResponse;
    }

    private WebResource.Builder getBuilder (WebResource webResource) {
        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON);
        return builder;
    }

    private WebResource addQueryParam (Dining entity, WebResource webResource) {

        webResource = webResource.queryParam("id", String.valueOf(entity.getId()));
        webResource = webResource.queryParam("credit_card_number", String.valueOf(entity.getCreditCardNumber()));
        webResource = webResource.queryParam("merchant_number", String.valueOf(entity.getMerchantNumber()));
        webResource = webResource.queryParam("dining_amount", String.valueOf(entity.getDiningAmount()));
        webResource = webResource.queryParam("dining_date", entity.getDiningDate());
        return webResource;
    }

}
