package com.glolabs.verkundenbot.persistence.repository.impl;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.glolabs.verkundenbot.persistence.model.Outlet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.glolabs.verkundenbot.persistence.repository.IOutletRepository;

@Repository
public class OutletRepositoryImpl implements IOutletRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Optional<Outlet> findById(Long id) {
        Outlet entity = entityManager.find(Outlet.class, id);
        return Optional.ofNullable(entity);
    }

    @Transactional
    @Override
    public Outlet save(Outlet outlet) {
        entityManager.persist(outlet);
        return outlet;
    }

}
