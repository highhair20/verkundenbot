package com.glolabs.verkundenbot.cloud.service.impl;

import com.glolabs.verkundenbot.cloud.exception.OutletNotSavedException;
import com.glolabs.verkundenbot.cloud.persistence.model.Device;
import com.glolabs.verkundenbot.cloud.persistence.repository.IDeviceRepository;
import com.glolabs.verkundenbot.cloud.service.IDeviceService;
import org.hibernate.type.UUIDCharType;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.threeten.bp.LocalDateTime;

import javax.persistence.Id;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements IDeviceService {

    private IDeviceRepository deviceRepository;

    public DeviceServiceImpl(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Optional<Device> findById(UUIDCharType uuid) {
        return deviceRepository.findById(uuid);
    }

    @Override
    public Device save(Device device) {
        if (StringUtils.isEmpty(device.getId())) {
            device.setCreatedTime(DateTime.now());
        }
        return deviceRepository.save(device);
    }

    @Override
    public Iterable<Device> findAll() {
        return deviceRepository.findAll();
    }

    public void delete(UUIDCharType id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public void createDeviceWithOutlets() throws OutletNotSavedException {

    }
}