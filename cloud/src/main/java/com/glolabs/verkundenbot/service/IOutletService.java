package com.glolabs.verkundenbot.service;

import java.util.Optional;

import com.glolabs.verkundenbot.persistence.model.Outlet;

public interface IOutletService {
    Optional<Outlet> findById(Long id);

    Outlet save(Outlet outlet);

    Iterable<Outlet> findAll();

    void delete(Long id);
}
