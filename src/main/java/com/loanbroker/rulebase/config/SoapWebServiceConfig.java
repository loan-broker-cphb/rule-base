package com.loanbroker.rulebase.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/rulebase/*");
    }

    @Bean
    public XsdSchema rulebaseSchema(){
        return new SimpleXsdSchema(new ClassPathResource("rulebase.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema rulebaseSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(rulebaseSchema);
        definition.setLocationUri("/rulebase");
        definition.setPortTypeName("BankService");
        definition.setTargetNamespace("http://techprimers.com/spring-boot-soap-example");
        return definition;
    }
}
