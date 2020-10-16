package com.example.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jibx.JibxMarshaller;

@SpringBootTest
class ClientApplicationTests {
    @Autowired
    private WebServiceClient webServiceClient;

    @Test
    void contextLoads() {
       // webServiceClient.send();
        webServiceClient.test();
     //  webServiceClient.simpleSendAndReceive();
    }

}
