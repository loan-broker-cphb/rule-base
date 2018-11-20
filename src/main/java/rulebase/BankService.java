
package rulebase;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Cherry Rose Semeña
 */
@WebService(serviceName = "BankService")
@Stateless()
public class BankService {

    @WebMethod(operationName = "makeLoan")
    public List<Bank> MakeLoan(@WebParam(name = "creditScore") int cs, @WebParam(name = "loanAmount") double la) {
        List<Bank> banks = new ArrayList();
        banks = getBanks(cs, la);
        return banks;
    }
    
    //Decision-making
    private List<Bank> getBanks(int creditScore, double loanAmount){
        List<Bank> banks = new ArrayList();
        if(creditScore > -1 && creditScore <= 800) {
            if ((loanAmount >= (double) 75000) && (creditScore >= 600)) {
                banks.add(new Bank("group4.bankRABBIT", "G4_RABBIT"));
            }
            if (((loanAmount >= (double) 10000) && (loanAmount <= (double) 74999)) && (creditScore >= 400)) {
                banks.add(new Bank("cphbusiness.bankXML", "CPHB_XML"));
                banks.add(new Bank("cphbusiness.bankJSON", "CPHB_JSON"));
            }
            banks.add(new Bank("group4.bankJSON", "G4_JSON"));
        }
        return banks;
    }
    
}
