package com.glolabs.verkundenbot.api;

import com.glolabs.verkundenbot.persistence.model.Device;
import com.glolabs.verkundenbot.persistence.model.Devices;
import com.glolabs.verkundenbot.persistence.model.ErrorResponse;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-07T03:16:15.186Z[GMT]")
@Controller
public class DeviceApiController implements DeviceApi {

    private static final Logger log = LoggerFactory.getLogger(DeviceApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DeviceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Device> getDeviceByUuid(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "the uuid of the device requested",required=true) @PathVariable("uuid") UUID uuid,@ApiParam(value = "which set of devices to return") @Valid @RequestParam(value = "page", required = false) Integer page) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Device>(objectMapper.readValue("{\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"office\",\n  \"description\" : \"The alert device located at the office\",\n  \"uuid\" : \"5fc98306-7936-4deb-b51d-32e46e1d984d\",\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Device.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Device>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Device>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devices> getDevices(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "which set of devices to return") @Valid @RequestParam(value = "page", required = false) Integer page) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Devices>(objectMapper.readValue("[ {\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"office\",\n  \"description\" : \"The alert device located at the office\",\n  \"uuid\" : \"5fc98306-7936-4deb-b51d-32e46e1d984d\",\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"office\",\n  \"description\" : \"The alert device located at the office\",\n  \"uuid\" : \"5fc98306-7936-4deb-b51d-32e46e1d984d\",\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", Devices.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Devices>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Devices>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Device> registerDevice(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = ""  )  @Valid @RequestBody Device body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Device>(objectMapper.readValue("{\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"office\",\n  \"description\" : \"The alert device located at the office\",\n  \"uuid\" : \"5fc98306-7936-4deb-b51d-32e46e1d984d\",\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Device.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Device>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Device>(HttpStatus.NOT_IMPLEMENTED);
    }

}
