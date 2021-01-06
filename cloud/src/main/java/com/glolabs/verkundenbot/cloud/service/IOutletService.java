package com.glolabs.verkundenbot.cloud.service;

import java.util.Optional;

import com.glolabs.verkundenbot.cloud.persistence.model.Outlet;

public interface IOutletService {
    Optional<Outlet> findById(Long id);

    Outlet save(Outlet outlet);

    Iterable<Outlet> findAll();

    void delete(Long id);
}
