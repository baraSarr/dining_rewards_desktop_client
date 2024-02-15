package com.rewardomain.rewardsdiningdesktopclient.invoker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.decoder.Encoder;
import com.rewardomain.rewardsdiningdesktopclient.entity.AccountContributionRequest;
import com.rewardomain.rewardsdiningdesktopclient.entity.Restaurant;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class AccountContributionInvoker implements AccountContributionInvokerInterface {

    private Client client;
    private String uri;

    public AccountContributionInvoker(String uri) {
        this.client = Client.create();
        this.uri = uri;
    }

    @Override
    public ClientResponse get(long number) {
        return null;
    }

    @Override
    public ClientResponse get() {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/accounts");
        return get(webResource);
    }

    @Override
    public ClientResponse post(AccountContributionRequest entity) throws JsonProcessingException {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/accounts");
        webResource = addQueryParam(entity, webResource);
        WebResource.Builder builder = getBuilder (webResource);
        String jsonInput = Encoder.toJson(entity);
        ClientResponse clientResponse = builder.post(ClientResponse.class, jsonInput);
        return clientResponse;
    }

    @Override
    public ClientResponse getBeneficaries(String accountNumber) {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/accounts/"+accountNumber+"/beneficiaries");
        return get(webResource);
    }

    @Override
    public ClientResponse postBeneficiary(String accountNumber, AccountContributionRequest entity) throws JsonProcessingException {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/accounts/"+accountNumber+"/beneficiaries");
        webResource = addQueryParam(entity, webResource);
        WebResource.Builder builder = getBuilder (webResource);
        String jsonInput = Encoder.toJson(entity);
        ClientResponse clientResponse = builder.post(ClientResponse.class, jsonInput);
        return clientResponse;
    }

    @Override
    public ClientResponse putBeneficiary(long id, AccountContributionRequest entity) throws JsonProcessingException {
        WebResource webResource = client.resource(uri);
        webResource = webResource.path("/beneficiaries/"+id);
        webResource = addQueryParam(entity, webResource);
        WebResource.Builder builder = getBuilder (webResource);
        String jsonInput = Encoder.toJson(entity);
        ClientResponse clientResponse = builder.put(ClientResponse.class, jsonInput);
        return clientResponse;
    }

    @Override
    public ClientResponse put(AccountContributionRequest entity) throws JsonProcessingException {
        return null;
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

    private WebResource addQueryParam (AccountContributionRequest entity, WebResource webResource) {

        webResource = webResource.queryParam("name", entity.getName());
        webResource = webResource.queryParam("credit_card_number", entity.getCcnumber());
        webResource = webResource.queryParam("account_number", entity.getAnumber());
        webResource = webResource.queryParam("allocation_percentage", String.valueOf(entity.getPercentage()));
        return webResource;
    }


}
