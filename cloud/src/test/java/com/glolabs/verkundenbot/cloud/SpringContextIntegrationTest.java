package com.glolabs.verkundenbot.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringContextIntegrationTest {

    @Test
    public void whenContextIsLoaded_thenNoExceptions() {
        //test
        System.out.println("foo");
    }
}