package com.chaow.camelrest.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MessageController2 extends RouteBuilder {

    @Autowired
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        rest()
            .get("/hello2")
            .produces(MediaType.APPLICATION_JSON.toString())
            .consumes(MediaType.APPLICATION_JSON.toString())
            .to("direct:hello2");

        from("direct:hello2")
            .log(LoggingLevel.INFO, "Logging :: route hello2. returning Hello World2")
            .transform()
            .simple("Hello World2");

    }
}
