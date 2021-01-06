package com.glolabs.verkundenbot.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class SpringContextIntegrationTest {

    @Test
    public void whenContextIsLoaded_thenNoExceptions() {
        //test
    }
}