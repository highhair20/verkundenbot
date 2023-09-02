//package com.glolabs.verkundenbot.cloud.controller;
//
//import com.glolabs.verkundenbot.cloud.persistence.model.ErrorResponse;
//import com.glolabs.verkundenbot.cloud.persistence.model.ModelApiResponse;
//import java.util.UUID;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.swagger.annotations.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.RestController;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.validation.constraints.*;
//import javax.validation.Valid;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-07T03:16:15.186Z[GMT]")
//@RestController
//@RequestMapping(value = "/alarm")
//public class AlarmController implements IAlarm {
//
//    private static final Logger log = LoggerFactory.getLogger(AlarmApiController.class);
//
//    private final ObjectMapper objectMapper;
//
//    private final HttpServletRequest request;
//
//    @org.springframework.beans.factory.annotation.Autowired
//    public AlarmController(ObjectMapper objectMapper, HttpServletRequest request) {
//        this.objectMapper = objectMapper;
//        this.request = request;
//    }
//
//    @ApiOperation(value = "", nickname = "startDeployment", notes = "Begin a deployment.", response = ModelApiResponse.class, tags={ "Alarms", })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "response", response = ModelApiResponse.class) })
//    @RequestMapping(value = "/alarm/deployment",
//            produces = { "application/json" },
//            method = RequestMethod.POST)
//    public ResponseEntity<ModelApiResponse> startDeployment(@ApiParam(value = "",required=true) @PathVariable("deviceId") String deviceId,@ApiParam(value = "",required=true, allowableValues="true, false") @PathVariable("value") String value) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{\n  \"code\" : 0,\n  \"message\" : \"Resource not found\"\n}", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    public ResponseEntity<ModelApiResponse> triggerInHandPixel(@ApiParam(value = "",required=true) @PathVariable("deviceId") String deviceId,@ApiParam(value = "",required=true) @PathVariable("value") Integer value,@ApiParam(value = "",required=true) @PathVariable("timeunit") Integer timeunit,@ApiParam(value = "", allowableValues = "seconds, minutes, milliseconds") @Valid @RequestParam(value = "units", required = false) String units) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{\n  \"code\" : 0,\n  \"message\" : \"Resource not found\"\n}", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    public ResponseEntity<ModelApiResponse> triggerInStorePixel(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{\n  \"code\" : 0,\n  \"message\" : \"Resource not found\"\n}", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    public ResponseEntity<ModelApiResponse> updateDeployment(@ApiParam(value = "",required=true) @PathVariable("deviceId") String deviceId,@ApiParam(value = "",required=true, allowableValues="true, false") @PathVariable("value") String value) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{\n  \"code\" : 0,\n  \"message\" : \"Resource not found\"\n}", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//}
