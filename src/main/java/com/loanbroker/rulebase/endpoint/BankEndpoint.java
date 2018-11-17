package com.loanbroker.rulebase.endpoint;

import com.loanbroker.rulebase.service.BankService;
import com.loanbroker.rulebase_soap.BankList;
import com.loanbroker.rulebase_soap.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BankEndpoint {

    @Autowired
    private BankService bankService;

    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
            localPart = "loanRequest")
    @ResponsePayload
    public BankList loanRequest(@RequestPayload LoanRequest request) {
        BankList response = bankService.getBanks(request.getCreditscore(), request.getLoanamount());
        response.getBanks();
        return response;
    }

}
