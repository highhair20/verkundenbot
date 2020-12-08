package com.glolabs.verkundenbot.persistence.repository;

import java.util.Optional;

import com.glolabs.verkundenbot.persistence.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOutletRepository extends JpaRepository<Outlet, Long> {

    Optional<Outlet> findById(Long id);

    Outlet save(Outlet outlet);

}
