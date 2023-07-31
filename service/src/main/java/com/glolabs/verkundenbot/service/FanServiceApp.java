package com.glolabs.verkundenbot.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

// Handler value: example.Handler
public class FanServiceApp<I, O> implements RequestHandler<ScheduledEvent, String>{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public String handleRequest(ScheduledEvent event, Context context)
    {
        System.out.println(event);
//        api.openweathermap.org/data/2.5/weather?zip=90802,us&units=imperial&appid=0c6da2a60072616a0ccc0ebc166589e4
//        LambdaLogger logger = context.getLogger();
//        // log execution details
//        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
//        logger.log("CONTEXT: " + gson.toJson(context));
//        // process event
//        logger.log("EVENT: " + gson.toJson(event));
//        logger.log("EVENT TYPE: " + event.getClass().toString());
//
//        JSONObject jo = new JSONObject();
//        jo.put("name", "jon doe");
//        jo.put("age", "22");
//        jo.put("city", "chicago");

        return "success";
    }
}
