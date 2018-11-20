# Rule Base

BANKS | LOAN AMOUNT | CREDIT SCORE  | ROUTING KEY |
------|-------------|---------------|-------------|
cphbusiness.bankXML | `10000 - 74999` | `> 399`  | `CPHB_XML` |
cphbusiness.bankJSON | `10000-74999` | `> 399` | `CPHB_JSON` |
group4.bankRABBIT | `> 75000` | `> 599` | `G4_RABBIT` |
group4.bankJSON | `default`| `0-800` |  `G4_JSON` | 

**WSDL URL: http://localhost:8080/ws/banks.wsdl**

**Loan Request:**

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:lr="http://spring.io/guides/gs-producing-web-service">
    <soapenv:Header/>
    <soapenv:Body>
        <lr:getBanksRequest>
            <lr:creditScore>600</lr:creditScore>
            <lr:loanAmount>73456.01</lr:loanAmount>
        </lr:getBanksRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

**Loan Response:**

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getBanksResponse xmlns:ns2="http://spring.io/guides/gs-producing-web-service">
            <ns2:banks>
                <ns2:name>cphbusiness.bankJSON</ns2:name>
                <ns2:routingkey>CPHB_JSON</ns2:routingkey>
            </ns2:banks>
            <ns2:banks>
                <ns2:name>cphbusiness.bankXML</ns2:name>
                <ns2:routingkey>CPHB_XML</ns2:routingkey>
            </ns2:banks>
            <ns2:banks>
                <ns2:name>group4.bankJSON</ns2:name>
                <ns2:routingkey>G4_JSON</ns2:routingkey>
            </ns2:banks>
        </ns2:getBanksResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
