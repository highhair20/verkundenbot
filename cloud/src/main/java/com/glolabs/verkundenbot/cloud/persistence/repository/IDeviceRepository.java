package com.glolabs.verkundenbot.cloud.persistence.repository;

import com.glolabs.verkundenbot.cloud.persistence.model.Device;
import org.hibernate.type.UUIDCharType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDeviceRepository extends PagingAndSortingRepository<Device, UUIDCharType> {

    public Optional<Device> findById(UUIDCharType uuid);

    @Query("select d from Device d where d.name like %?1%")
    List<Device> findByNameMatches(String name);

    Optional<Device> findByName(String name);

}
