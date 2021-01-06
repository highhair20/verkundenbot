package com.glolabs.verkundenbot.cloud.persistence.repository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.threeten.bp.LocalDateTime;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.glolabs.verkundenbot.cloud.persistence.model.Outlet;


@SpringBootTest
public class OutletRepositoryIntegrationTest {

    @Autowired
    private IOutletRepository outletRepository;

    @Test
    public void whenSavingNewOutlet_thenSuccess() {
        Outlet newOutlet = new Outlet(randomAlphabetic(6));

        assertThat(outletRepository.save(newOutlet), is(notNullValue()));
    }

//    @Test
//    public void givenOutlet_whenFindById_thenSuccess() {
//        Outlet newOutlet = new Outlet(randomAlphabetic(6));
//        outletRepository.save(newOutlet);
//
//        Optional<Outlet> retrievedOutlet = outletRepository.findById(newOutlet.getId());
//
//        assertThat(retrievedOutlet.get(), is(equalTo(newOutlet)));
//    }

//    @Test
//    public void givenOutlet_whenFindByName_thenSuccess() {
//        Outlet newOutlet = new Outlet(randomAlphabetic(6));
//        outletRepository.save(newOutlet);
//
//        Optional<Outlet> retrievedOutlet = outletRepository.findByName(newOutlet.getName());
//
//        assertThat(retrievedOutlet.get(), is(equalTo(newOutlet)));
//    }

//    @Test
//    public void givenOutletCreate_whenFindByDateCreated_thenSuccess() {
//        Outlet oldOutlet = new Outlet(randomAlphabetic(6));
//        outletRepository.save(oldOutlet);
//
//        Outlet newOutlet = new Outlet(randomAlphabetic(6), LocalDateTime.now());
//        outletRepository.save(newOutlet);
//
//        Outlet newOutlet2 = new Outlet(randomAlphabetic(6), LocalDateTime.now());
//        outletRepository.save(newOutlet2);
//
//        List<Outlet> retrievedOutlets = outletRepository.findByCreatedTimeBetween(LocalDateTime.now().minusDays(1),
//                LocalDateTime.now().plusDays(1));
//
//        assertThat(retrievedOutlets, hasItems(newOutlet, newOutlet2));
//    }

}