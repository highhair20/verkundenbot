package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.Plug;
import io.swagger.model.Plugs;
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
public class PlugApiController implements PlugApi {

    private static final Logger log = LoggerFactory.getLogger(PlugApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlugApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Plugs> getPlugs(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Plugs>(objectMapper.readValue("[ {\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The plug that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The plug that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", Plugs.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Plugs>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Plugs>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Plug> getPlugsByZone(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid,@ApiParam(value = "Zone of the plug being requested",required=true, allowableValues="a, b, c, d") @PathVariable("zone") String zone) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Plug>(objectMapper.readValue("{\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The plug that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Plug.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Plug>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Plug>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Plug> setDimmer(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid,@ApiParam(value = "Predefined zone of the plug",required=true, allowableValues="a, b, c, d") @PathVariable("zone") String zone,@ApiParam(value = ""  )  @Valid @RequestBody Plug body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Plug>(objectMapper.readValue("{\n  \"zone\" : \"a\",\n  \"update_dtime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Reading Lamp\",\n  \"description\" : \"The plug that controls the reading lamp\",\n  \"id\" : 164274,\n  \"state\" : true,\n  \"create_dtime\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Plug.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Plug>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Plug>(HttpStatus.NOT_IMPLEMENTED);
    }

}
