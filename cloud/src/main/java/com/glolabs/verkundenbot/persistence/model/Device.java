package com.glolabs.verkundenbot.persistence.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Device
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-07T03:16:15.186Z[GMT]")
public class Device   {
  @JsonProperty("uuid")
  private UUID uuid = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("update_dtime")
  private OffsetDateTime updateDtime = null;

  @JsonProperty("create_dtime")
  private OffsetDateTime createDtime = null;

  public Device uuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "5fc98306-7936-4deb-b51d-32e46e1d984d", value = "")
  @Valid
  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public Device name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "office", required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Device description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "The alert device located at the office", value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Device updateDtime(OffsetDateTime updateDtime) {
    this.updateDtime = updateDtime;
    return this;
  }

  /**
   * Get updateDtime
   * @return updateDtime
  **/
  @ApiModelProperty(value = "")
  @Valid
  public OffsetDateTime getUpdateDtime() {
    return updateDtime;
  }

  public void setUpdateDtime(OffsetDateTime updateDtime) {
    this.updateDtime = updateDtime;
  }

  public Device createDtime(OffsetDateTime createDtime) {
    this.createDtime = createDtime;
    return this;
  }

  /**
   * Get createDtime
   * @return createDtime
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OffsetDateTime getCreateDtime() {
    return createDtime;
  }

  public void setCreateDtime(OffsetDateTime createDtime) {
    this.createDtime = createDtime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Device device = (Device) o;
    return Objects.equals(this.uuid, device.uuid) &&
        Objects.equals(this.name, device.name) &&
        Objects.equals(this.description, device.description) &&
        Objects.equals(this.updateDtime, device.updateDtime) &&
        Objects.equals(this.createDtime, device.createDtime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, description, updateDtime, createDtime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Device {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    updateDtime: ").append(toIndentedString(updateDtime)).append("\n");
    sb.append("    createDtime: ").append(toIndentedString(createDtime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
