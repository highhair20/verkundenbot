/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.Plug;
import io.swagger.model.Plugs;
import java.util.UUID;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-07T03:16:15.186Z[GMT]")
@Api(value = "plug", description = "the plug API")
public interface PlugApi {

    @ApiOperation(value = "", nickname = "getPlugs", notes = "returns all plugs with their states for a given device", response = Plugs.class, tags={ "Plugs", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "response", response = Plugs.class),
        @ApiResponse(code = 403, message = "Access Denied", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "Plug not found", response = ErrorResponse.class) })
    @RequestMapping(value = "/plug",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Plugs> getPlugs(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid);


    @ApiOperation(value = "", nickname = "getPlugsByZone", notes = "returns information about a specific plug including its state", response = Plug.class, tags={ "Plugs", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "response", response = Plug.class),
        @ApiResponse(code = 400, message = "Invalid zone requested", response = ErrorResponse.class),
        @ApiResponse(code = 403, message = "Access Denied", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "Plug not found", response = ErrorResponse.class) })
    @RequestMapping(value = "/plug/{zone}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Plug> getPlugsByZone(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid,@ApiParam(value = "Zone of the plug being requested",required=true, allowableValues="a, b, c, d") @PathVariable("zone") String zone);


    @ApiOperation(value = "", nickname = "setDimmer", notes = "", response = Plug.class, tags={ "Plugs", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "response", response = Plug.class),
        @ApiResponse(code = 400, message = "Invalid zone requested", response = ErrorResponse.class),
        @ApiResponse(code = 403, message = "Access Denied", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "Plug not found", response = ErrorResponse.class) })
    @RequestMapping(value = "/plug/{zone}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Plug> setDimmer(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "" ,required=true) @RequestHeader(value="X-Device-Uuid", required=true) UUID xDeviceUuid,@ApiParam(value = "Predefined zone of the plug",required=true, allowableValues="a, b, c, d") @PathVariable("zone") String zone,@ApiParam(value = ""  )  @Valid @RequestBody Plug body);

}
