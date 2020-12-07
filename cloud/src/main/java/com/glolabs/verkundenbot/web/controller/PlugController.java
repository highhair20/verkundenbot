package com.glolabs.verkundenbot.web.controller;

import com.glolabs.verkundenbot.service.IPlugService;

// import com.glolabs.verkundenbot.persistence.model.ErrorResponse;
import com.glolabs.verkundenbot.persistence.model.Plug;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import javax.validation.Valid;
//import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/plug")
public class PlugController {

    private static final Logger log = LoggerFactory.getLogger(PlugController.class);

    private IPlugService plugService;

    public PlugController(IPlugService plugService) {
        this.plugService = plugService;
    }


//    public PlugDto findOne(@PathVariable Integer id) {
//        Plug entity = plugService.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return convertToDto(entity);
//    }

    @GetMapping(value = "/{id}", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<Plug> getPlug(@Valid @PathVariable("id") Integer id) {
        Plug plug = plugService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        ResponseEntity<Plug> response = new ResponseEntity(plug.toString(), HttpStatus.OK);
        return response;
    }

//    public ResponseEntity<Plugs> getPlugs(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Plugs>(objectMapper.readValue("[ {\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The plug that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The plug that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", Plugs.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Plugs>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<Plugs>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//
//    public ResponseEntity<Plug> setDimmer(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid,@ApiParam(value = "Predefined zone of the plug",required=true, allowableValues="a, b, c, d") @PathVariable("zone") String zone,@ApiParam(value = ""  )  @Valid @RequestBody Plug body) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Plug>(objectMapper.readValue("{\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The plug that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Plug.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Plug>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<Plug>(HttpStatus.NOT_IMPLEMENTED);
//    }

}
