package com.example.client.config;

import com.example.client.common.GetCountryRequest;
import com.example.client.common.GetCountryResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.jibx.JibxMarshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

/**
 * @author xuxu
 */
@Configuration
public class WebServiceConfig {
    @Bean
    public SaajSoapMessageFactory saajSoapMessageFactory(){
        return new SaajSoapMessageFactory();
    }
    @Bean
    public WebServiceTemplate webServiceTemplate(SaajSoapMessageFactory saajSoapMessageFactory){
        WebServiceTemplate w=new WebServiceTemplate();
        w.setDefaultUri("http://localhost:8081/ws");
        w.setMessageFactory(saajSoapMessageFactory);
        Jaxb2Marshaller j= new Jaxb2Marshaller();
        j.setContextPath("com.example.client.common");
        w.setUnmarshaller(j);
        w.setMarshaller(j);
        return w;
    }
}
