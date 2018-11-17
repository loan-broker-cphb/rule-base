package com.loanbroker.rulebase.service;

import com.loanbroker.rulebase_soap.Bank;
import com.loanbroker.rulebase_soap.BankList;
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
    public void initialize() {
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        Bank bank3 = new Bank();
        Bank bank4 = new Bank();
        bank1.setName("cphbusiness.bankXML");
        bank2.setName("cphbusiness.bankJSON");
        bank3.setName("group4.bankRABBIT");
        bank4.setName("group4.bankJSON");
        bank1.setRoutingkey("CPHB_XML");
        bank2.setRoutingkey("CPHB_JSON");
        bank3.setRoutingkey("G4_RABBIT");
        bank4.setRoutingkey("G4_JSON");
        banks.put(bank1.getName(), bank1);
        banks.put(bank2.getName(), bank2);
        banks.put(bank3.getName(), bank3);
        banks.put(bank4.getName(), bank4);
    }

    public BankList getBanks(int creditScore, double loanAmount) {
        List<Bank> lenders = new ArrayList();
        if(creditScore > -1 && creditScore < 800) {
            if ((loanAmount >= (double) 75000) && (creditScore >= 600)) {
                lenders.add(banks.get("group4.bankRABBIT"));
            }
            if (((loanAmount >= (double) 10000) && (loanAmount <= (double) 74999)) && (creditScore >= 400)) {
                lenders.add(banks.get("cphbusiness.bankXML"));
                lenders.add(banks.get("cphbusiness.bankJSON"));
            }
            lenders.add(banks.get("group4.bankJSON"));
        }
        BankList banksToReturn = new BankList();
        banksToReturn.setBanks(lenders);
        return banksToReturn;
    }
}
