package com.chaow.camelrest.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MessageController extends RouteBuilder {

    @Autowired
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        rest()
            .get("/hello")
            .produces(MediaType.APPLICATION_JSON.toString())
            .consumes(MediaType.APPLICATION_JSON.toString())
            .to("direct:hello");

        from("direct:hello")
            .log(LoggingLevel.INFO, "Logging :: route hello. returning Hello World")
            .transform()
            .simple("Hello World");

    }
}
