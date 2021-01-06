package com.glolabs.verkundenbot.cloud.persistence.repository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.time.LocalDate;

import com.glolabs.verkundenbot.cloud.persistence.model.Device;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class TestDataLoader implements ApplicationContextAware {

    @Autowired
    private IDeviceRepository deviceRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        deviceRepository.save(new Device());
        deviceRepository.save(new Device());
        deviceRepository.save(new Device());
        deviceRepository.save(new Device());
    }
}

