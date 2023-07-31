package com.glolabs.verkundenbot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.joda.deser.key.DateTimeKeyDeserializer;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import org.mockito.Mock;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FanServiceAppTest {

  @Mock
  Context context;

  @Test
  public void successfulResponse() throws IOException {

    // Given
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    objectMapper.registerModule(new JodaModule());

    InputStream eventStream = this.getClass().getResourceAsStream("/event.json");
    ScheduledEvent event = objectMapper.readValue(eventStream, ScheduledEvent.class);
    FanServiceApp<ScheduledEvent, String> handler = new FanServiceApp<>();

    // When
    String result = handler.handleRequest(event, context);

    // Then
    assertTrue(result.contains("success"));
  }
}
