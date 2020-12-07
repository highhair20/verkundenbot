package com.glolabs.verkundenbot.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.glolabs.verkundenbot.persistence.model.Plug;

public interface IPlugRepository extends JpaRepository<Plug, Integer> {

    Optional<Plug> findById(Integer id);

    Plug save(Plug plug);

}
