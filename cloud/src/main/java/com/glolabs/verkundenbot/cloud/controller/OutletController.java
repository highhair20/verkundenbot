package com.glolabs.verkundenbot.cloud.controller;

import com.glolabs.verkundenbot.cloud.persistence.model.Outlet;
import com.glolabs.verkundenbot.cloud.service.IOutletService;

// import com.glolabs.verkundenbot.cloud.persistence.model.ErrorResponse;

import org.springframework.web.bind.annotation.*;
import org.threeten.bp.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
//import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/outlet")
public class OutletController {

    private static final Logger log = LoggerFactory.getLogger(OutletController.class);

    private IOutletService outletService;

    public OutletController(IOutletService outletService) {
        this.outletService = outletService;
    }

    @PostMapping(value = "/{id}", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<Outlet> createOutlet(@Valid @PathVariable("id") Long id) {
        Outlet outlet = new Outlet("My First Outlet");
        outletService.save(outlet);

        Optional<Outlet> optionalOutlet = outletService.findById(outlet.getId());
        optionalOutlet.ifPresent(System.out::println);

        return ResponseEntity.accepted().body(outlet);
    }

//    public OutletDto findOne(@PathVariable Long id) {
//        Outlet entity = outletService.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return convertToDto(entity);
//    }

    @GetMapping(value = "/{id}", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<Outlet> getOutlet(@Valid @PathVariable("id") Long id) {
        Outlet outlet = new Outlet("My First Outlet");
        outletService.save(outlet);

        Optional<Outlet> optionalOutlet = outletService.findById(outlet.getId());
        optionalOutlet.ifPresent(System.out::println);
        return ResponseEntity.accepted().body(outlet);
    }

//    public ResponseEntity<Outlets> getOutlets(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Outlets>(objectMapper.readValue("[ {\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The outlet that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The outlet that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", Outlets.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Outlets>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<Outlets>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//
//    public ResponseEntity<Outlet> setDimmer(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid,@ApiParam(value = "Predefined zone of the outlet",required=true, allowableValues="a, b, c, d") @PathVariable("zone") String zone,@ApiParam(value = ""  )  @Valid @RequestBody Outlet body) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Outlet>(objectMapper.readValue("{\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The outlet that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Outlet.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Outlet>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<Outlet>(HttpStatus.NOT_IMPLEMENTED);
//    }

}
