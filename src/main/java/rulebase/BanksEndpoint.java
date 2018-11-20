package rulebase;

import io.spring.guides.gs_producing_web_service.Bank;
import io.spring.guides.gs_producing_web_service.GetBanksRequest;
import io.spring.guides.gs_producing_web_service.GetBanksResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class BanksEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBanksRequest")
    @ResponsePayload
    public GetBanksResponse getCountry(@RequestPayload GetBanksRequest request) {
        List<Bank> banks = getBanks(request.getCreditScore(), request.getLoanAmount());
        GetBanksResponse response = new GetBanksResponse();

        for (Bank bank : banks) {
            response.getBanks().add(bank);
        }

        return response;
    }

    private List<Bank> getBanks(int creditScore, double loanAmount){
        List<Bank> banks = new ArrayList();
        if(creditScore > -1 && creditScore <= 800) {
            if ((loanAmount >= (double) 75000) && (creditScore >= 600)) {
                Bank bank = new Bank();
                bank.setName("group4.bankRABBIT");
                bank.setRoutingkey("G4_RABBIT");
                banks.add(bank);
            }
            if (((loanAmount >= (double) 10000) && (loanAmount <= (double) 74999)) && (creditScore >= 400)) {
                Bank jsonBank = new Bank();
                jsonBank.setName("cphbusiness.bankJSON");
                jsonBank.setRoutingkey("CPHB_JSON");

                Bank xmlBank = new Bank();
                xmlBank.setName("cphbusiness.bankXML");
                xmlBank.setRoutingkey("CPHB_XML");

                banks.add(jsonBank);
                banks.add(xmlBank);
            }
            Bank bank = new Bank();
            bank.setName("group4.bankJSON");
            bank.setRoutingkey("G4_JSON");
            banks.add(bank);
        }
        return banks;
    }
}
