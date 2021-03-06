package com.redhat.samples.switchyard.versioning.service.v1_0;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.switchyard.component.test.mixins.http.HTTPMixIn;

public class GreetingClient {

    private static final String ENDPOINT_URL = "http://localhost:8080/sample/service/v1.0/GreetingService";

    public static void main(String[] args) throws IOException {
        HTTPMixIn httpMixIn = new HTTPMixIn();
        httpMixIn.initialize();
        try {
            String response = httpMixIn.postString(ENDPOINT_URL,
                    IOUtils.toString(GreetingClient.class.getResource("/xml/hello-request_v1_0.xml")));
            System.out.println(response);
        } finally {
            httpMixIn.uninitialize();
        }
    }

}
