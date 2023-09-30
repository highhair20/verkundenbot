package com.glolabs.verkundenbot.cloud;

import com.glolabs.verkundenbot.cloud.persistence.model.Outlet;
import com.glolabs.verkundenbot.cloud.service.IOutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {

    @Autowired
    private IOutletService outletService;

    public static void main(final String... args) {
        SpringApplication.run(App.class, args);
    }

//    @PostConstruct
//    public void postConstruct() {
//        Outlet outlet = new Outlet("My First Project", LocalDateTime.now());
//        outletService.save(outlet);
//
//        Optional<Project> optionalProject = projectService.findById(outlet.getId());
//        optionalProject.ifPresent(System.out::println);
//    }
}
