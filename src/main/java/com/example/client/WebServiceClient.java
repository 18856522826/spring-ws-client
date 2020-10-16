package com.example.client;

import com.example.client.common.GetCountryRequest;
import com.example.client.common.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.*;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.w3c.dom.Document;

import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;

@Component
public class WebServiceClient {
    private static final String MESSAGE =
            "<message xmlns=\"http://www.dexcoder.com/ws\">Hello Web Service World</message>";
    @Autowired
    private  WebServiceTemplate webServiceTemplate;

    public void setDefaultUri(String defaultUri) {
        webServiceTemplate.setDefaultUri(defaultUri);
    }

    // send to the configured default URI
    public void simpleSendAndReceive() {
        StreamSource source = new StreamSource(new StringReader(MESSAGE));
        StreamResult result = new StreamResult(System.out);
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);
    }

    // send to an explicit URI
    public void customSendAndReceive() {
        StreamSource source = new StreamSource(new StringReader(MESSAGE));
        StreamResult result = new StreamResult(System.out);
        webServiceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/AnotherWebService",
                source, result);
    }
    public void send(){
        GetCountryRequest g=new GetCountryRequest();
        g.setName("aa");
        webServiceTemplate.marshalSendAndReceive(g);
    }
    public void test(){
        Request request=new Request();
        request.setBeginTime("asda");
        request.setTableName("dasda");
        request.setEndTime("dasda");
        webServiceTemplate.marshalSendAndReceive(request, new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
               SoapElement soapBody=((SoapMessage)message).getSoapBody();
            }
        });
    }
}
