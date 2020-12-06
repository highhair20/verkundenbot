package com.glolabs.verkundenbot.persistence.repository;

import java.util.Optional;
import org.springframework.data.repository.JpaRepository;
import com.glolabs.verkundenbot.persistence.model.Plug;

public interface IPlugRepository extends JpaRepository<Plug, Long> {

    Optional<Plug> findById(Long id);

    Plug save(Plug plug);

}
