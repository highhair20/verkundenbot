package com.glolabs.verkundenbot.cloud.persistence.repository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.glolabs.verkundenbot.cloud.persistence.model.Plug;

@SpringBootTest
public class PlugRepositoryIntegrationTest {

    @Autowired
    private IPlugRepository plugRepository;

    @Test
    public void whenSavingNewPlug_thenSuccess() {
        Plug newPlug = new Plug(randomAlphabetic(6), LocalDate.now());

        assertThat(plugRepository.save(newPlug), is(notNullValue()));
    }

    @Test
    public void givenPlug_whenFindById_thenSuccess() {
        Plug newPlug = new Plug(randomAlphabetic(6), LocalDate.now());
        plugRepository.save(newPlug);

        Optional<Plug> retrievedPlug = plugRepository.findById(newPlug.getId());

        assertThat(retrievedPlug.get(), is(equalTo(newPlug)));
    }

}