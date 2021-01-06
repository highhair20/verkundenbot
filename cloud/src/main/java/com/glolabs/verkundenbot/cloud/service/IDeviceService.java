package com.glolabs.verkundenbot.cloud.service;

import com.glolabs.verkundenbot.cloud.exception.OutletNotSavedException;
import com.glolabs.verkundenbot.cloud.persistence.model.Device;
import org.hibernate.type.UUIDCharType;

import java.util.Optional;

public interface IDeviceService {
    Iterable<Device> findAll();

    Optional<Device> findById(UUIDCharType id);

    Device save(Device project);

    void createDeviceWithOutlets() throws OutletNotSavedException;
}
