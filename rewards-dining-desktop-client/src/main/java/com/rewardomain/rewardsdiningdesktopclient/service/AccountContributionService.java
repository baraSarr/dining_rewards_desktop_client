package com.rewardomain.rewardsdiningdesktopclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewardomain.rewardsdiningdesktopclient.entity.*;
import com.rewardomain.rewardsdiningdesktopclient.invoker.AccountContributionInvoker;
import com.rewardomain.rewardsdiningdesktopclient.invoker.AccountContributionInvokerInterface;
import com.rewardomain.rewardsdiningdesktopclient.invoker.InvokerInterface;
import com.sun.jersey.api.client.ClientResponse;

import java.util.List;

public class AccountContributionService implements IAccountContributionService{

    private final AccountContributionInvokerInterface invoker;
    private ObjectMapper decoder;
    public static final String RESOURCE_URI = "http://localhost:8765/account-contribution";

    public AccountContributionService() {
        decoder = new ObjectMapper();
        invoker = new AccountContributionInvoker(RESOURCE_URI);
    }

    @Override
    public DefaultResponse createAccount(AccountContributionRequest request) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.post(request);
        String json = clientResponse.getEntity(String.class);
        DefaultResponse response = decoder.readValue(json, DefaultResponse.class);
        return response;
    }

    @Override
    public List<Account> getAccounts() throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.get();
        String json = clientResponse.getEntity(String.class);
        List<Account> response = decoder.readValue(json, new TypeReference<List<Account>>(){});
        return response;
    }

    @Override
    public DefaultResponse createBeneficiary(String accountNumber, AccountContributionRequest request) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.postBeneficiary(accountNumber, request);
        String json = clientResponse.getEntity(String.class);
        DefaultResponse response = decoder.readValue(json, DefaultResponse.class);
        return response;
    }

    @Override
    public List<Beneficiary> getBeneficiaries(String accountNumber) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.getBeneficaries(accountNumber);
        String json = clientResponse.getEntity(String.class);
        List<Beneficiary> response = decoder.readValue(json, new TypeReference<List<Beneficiary>>(){});
        return response;
    }

    @Override
    public DefaultResponse updateBeneficiary(long id, AccountContributionRequest request) throws JsonMappingException, JsonProcessingException {
        ClientResponse clientResponse = invoker.putBeneficiary(id, request);
        String json = clientResponse.getEntity(String.class);
        DefaultResponse response = decoder.readValue(json, DefaultResponse.class);
        return response;
    }
}
