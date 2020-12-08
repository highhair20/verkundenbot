package com.glolabs.verkundenbot.cloud.persistence.repository;

import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.glolabs.verkundenbot.cloud.persistence.model.Outlet;

@SpringBootTest
public class OutletRepositoryIntegrationTest {

    @Autowired
    private IOutletRepository outletRepository;

    @Test
    public void whenSavingNewOutlet_thenSuccess() {
        Outlet newOutlet = new Outlet(randomAlphabetic(6), LocalDate.now());

        assertThat(outletRepository.save(newOutlet), is(notNullValue()));
    }

    @Test
    public void givenOutlet_whenFindById_thenSuccess() {
        Outlet newOutlet = new Outlet(nextLong());
        outletRepository.save(newOutlet);

        Optional<Outlet> retrievedOutlet = outletRepository.findById(newOutlet.getId());

        assertThat(retrievedOutlet.get(), is(equalTo(newOutlet)));
    }

}