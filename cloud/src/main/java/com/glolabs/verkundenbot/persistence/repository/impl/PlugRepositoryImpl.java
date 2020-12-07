package com.glolabs.verkundenbot.persistence.repository.impl;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.glolabs.verkundenbot.persistence.model.Plug;
import com.glolabs.verkundenbot.persistence.repository.IPlugRepository;

@Repository
public class PlugRepositoryImpl implements IPlugRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Optional<Plug> findById(Long id) {
        Plug entity = entityManager.find(Plug.class, id);
        return Optional.ofNullable(entity);
    }

    @Transactional
    @Override
    public Plug save(Plug plug) {
        entityManager.persist(plug);
        return plug;
    }

}
