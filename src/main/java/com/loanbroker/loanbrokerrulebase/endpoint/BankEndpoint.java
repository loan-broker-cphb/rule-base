package com.loanbroker.loanbrokerrulebase.endpoint;

import com.loanbroker.loanbrokerrulebase.service.BankService;
import com.techprimers.spring_boot_soap_example.BankList;
import com.techprimers.spring_boot_soap_example.LoanRequest;
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
