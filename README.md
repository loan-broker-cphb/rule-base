# Rule Base

BANKS | LOAN AMOUNT | CREDIT SCORE  | ROUTING KEY |
------|-------------|---------------|-------------|
cphbusiness.bankXML | `10000 - 74999` | `> 399`  | `rkey1XML` |
cphbusiness.bankJSON | `10000-74999` | `> 399` | `rkey2JSON` |
group4.bankRABBIT | `> 75000` | `> 599` | `rkey3RABBIT` |
group4.bankREST | `default`| `default` |  `rkey4REST` | 

**POST Request: localhost:8091/rulebase**

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:lr="http://techprimers.com/spring-boot-soap-example">
    <soapenv:Header/>
    <soapenv:Body>
        <lr:loanRequest>
            <lr:creditscore>423</lr:creditscore>
            <lr:loanamount>73456.01</lr:loanamount>
        </lr:loanRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

**Response:**

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:BankList xmlns:ns2="http://techprimers.com/spring-boot-soap-example">
            <ns2:banks>
                <ns2:name>cphbusiness.bankXML</ns2:name>
                <ns2:routingkey>rkey1XML</ns2:routingkey>
            </ns2:banks>
            <ns2:banks>
                <ns2:name>cphbusiness.bankJSON</ns2:name>
                <ns2:routingkey>rkey2JSON</ns2:routingkey>
            </ns2:banks>
            <ns2:banks>
                <ns2:name>group4.bankREST</ns2:name>
                <ns2:routingkey>rkey4REST</ns2:routingkey>
            </ns2:banks>
        </ns2:BankList>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```