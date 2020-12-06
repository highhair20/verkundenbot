package com.glolabs.verkundenbot.service;

import java.util.Optional;

import com.glolabs.verkundenbot.persistence.model.Plug;

public interface IPlugService {
    Optional<Plug> findById(Integer id);

    Plug save(Plug plug);

    Iterable<Plug> findAll();

    void delete(Integer id);
}
