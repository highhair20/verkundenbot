package com.glolabs.verkundenbot.cloud.persistence.repository;

import com.glolabs.verkundenbot.cloud.persistence.model.Device;
import org.hibernate.type.UUIDCharType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DeviceRepositoryIntegrationTest {

    @Autowired
    private IDeviceRepository deviceRepository;

    @Test
    public void whenSavingNewDevice_thenSuccess() {
        UUIDCharType id = new UUIDCharType();
        Device newDevice = new Device(id);

        assertNotNull(deviceRepository.save(newDevice));
    }

    @Test
    public void givenDevice_whenFindById_thenSuccess() {
        UUIDCharType id = new UUIDCharType();
        Device newDevice = new Device(id);
        deviceRepository.save(newDevice);

        Optional<Device> retrievedDevice = deviceRepository.findById(newDevice.getId());
        assertEquals(retrievedDevice.get(), newDevice);
    }

    @Test
    public void givenDateCreated_whenFindAllPaginated_thenSuccess() {
//        Page<Device> retrievedDevices = deviceRepository.findAll(PageRequest.of(0, 2));
//
//        assertThat(retrievedDevices.getContent(), hasSize(2));
    }

    @Test
    public void givenDateCreated_whenFindAllSort_thenSuccess() {
//        List<Device> retrievedDevices = (List<Device>) deviceRepository.findAll(Sort.by(Sort.Order.asc("name")));
//
//        List<Device> sortedDevices = retrievedDevices.stream()
//                .collect(Collectors.toList());
//        sortedDevices.sort(Comparator.comparing(Device::getName));
//
//        Assert.assertEquals(sortedDevices, retrievedDevices);
    }

    @Test
    public void givenDateCreated_whenFindAllPaginatedAndSort_thenSuccess() {
        Page<Device> retrievedDevices = deviceRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));

        assertThat(retrievedDevices.getContent(), hasSize(2));
    }
}