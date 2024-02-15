package com.rewardomain.rewardsdiningdesktopclient.invoker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewardomain.rewardsdiningdesktopclient.entity.AccountContributionRequest;
import com.sun.jersey.api.client.ClientResponse;

public interface AccountContributionInvokerInterface extends InvokerInterface<AccountContributionRequest> {
    public ClientResponse getBeneficaries(String accountNumber);
    public ClientResponse postBeneficiary(String accountNumber, AccountContributionRequest entity) throws JsonProcessingException;

    public ClientResponse putBeneficiary(long id, AccountContributionRequest entity) throws JsonProcessingException;
}
