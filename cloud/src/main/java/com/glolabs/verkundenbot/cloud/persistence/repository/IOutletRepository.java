package com.glolabs.verkundenbot.cloud.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.glolabs.verkundenbot.cloud.persistence.model.Outlet;
import org.springframework.data.repository.CrudRepository;
import org.threeten.bp.LocalDateTime;

public interface IOutletRepository extends CrudRepository<Outlet, Long> {

    Optional<Outlet> findByName(String name);

    List<Outlet> findByCreatedTimeBetween(LocalDateTime start, LocalDateTime end);
}
