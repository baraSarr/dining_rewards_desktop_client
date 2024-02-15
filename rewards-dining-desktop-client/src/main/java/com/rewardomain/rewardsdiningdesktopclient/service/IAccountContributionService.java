package com.rewardomain.rewardsdiningdesktopclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.Account;
import com.rewardomain.rewardsdiningdesktopclient.entity.AccountContributionRequest;
import com.rewardomain.rewardsdiningdesktopclient.entity.Beneficiary;
import com.rewardomain.rewardsdiningdesktopclient.entity.DefaultResponse;

import java.util.List;

public interface IAccountContributionService {

    public DefaultResponse createAccount(AccountContributionRequest request) throws JsonMappingException, JsonProcessingException;
    public List<Account> getAccounts() throws JsonMappingException, JsonProcessingException;
    public DefaultResponse createBeneficiary(String accountNumber, AccountContributionRequest request) throws JsonMappingException, JsonProcessingException;
    public List<Beneficiary> getBeneficiaries(String accountNumber) throws JsonMappingException, JsonProcessingException;

    public DefaultResponse updateBeneficiary(long id, AccountContributionRequest request) throws JsonMappingException, JsonProcessingException;


}
