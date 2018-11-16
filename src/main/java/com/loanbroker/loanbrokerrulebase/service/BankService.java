package com.loanbroker.loanbrokerrulebase.service;

import com.techprimers.spring_boot_soap_example.Bank;
import com.techprimers.spring_boot_soap_example.BankList;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankService {

    private static final Map<String, Bank> banks = new HashMap<>();

    @PostConstruct
    public void initialize(){
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        Bank bank3 = new Bank();
        Bank bank4 = new Bank();
        bank1.setName("cphbusiness.bankXML");
        bank2.setName("cphbusiness.bankJSON");
        bank3.setName("group4.bankREST");
        bank4.setName("group4.bankRABBIT");
        bank1.setRoutingkey("rkey1XML");
        bank2.setRoutingkey("rkey2JSON");
        bank3.setRoutingkey("rkey3REST");
        bank4.setRoutingkey("rKey4RABBIT");
        banks.put(bank1.getName(), bank1);
        banks.put(bank2.getName(), bank2);
        banks.put(bank3.getName(), bank3);
        banks.put(bank4.getName(), bank4);
    }

    public BankList getBanks(int creditScore, double loanAmount){
        List<Bank> lenders = new ArrayList();
        if ((loanAmount >= (double) 75000) && (creditScore >= 600)) {
            lenders.add(banks.get("cphbusiness.bankJSON"));
            lenders.add(banks.get("group4.bankREST"));
        }
        if (((loanAmount >= (double) 10000) && (loanAmount <= (double) 74999)) && (creditScore >= 400)) {
            lenders.add(banks.get("cphbusiness.bankXML"));
        }
        lenders.add(banks.get("group4.bankRABBIT"));
        BankList banksToReturn = new BankList();
        banksToReturn.setBanks(lenders);
        return banksToReturn;
    }
}
