package com.glolabs.verkundenbot.persistence.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Plug
 */
@Validated
public class Plug   {
  @JsonProperty("id")
  private Integer id = null;

  /**
   * Gets or Sets zone
   */
  public enum ZoneEnum {
    A("a"),
    
    B("b"),
    
    C("c"),
    
    D("d");

    private String value;

    ZoneEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ZoneEnum fromValue(String text) {
      for (ZoneEnum b : ZoneEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("zone")
  private ZoneEnum zone = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("state")
  private Boolean state = null;

  @JsonProperty("update_dtime")
  private OffsetDateTime updateDtime = null;

  @JsonProperty("create_dtime")
  private OffsetDateTime createDtime = null;

  public Plug id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "164274", required = true, value = "")
      @NotNull

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Plug zone(ZoneEnum zone) {
    this.zone = zone;
    return this;
  }

  /**
   * Get zone
   * @return zone
  **/
  @ApiModelProperty(example = "a", value = "")
  
    public ZoneEnum getZone() {
    return zone;
  }

  public void setZone(ZoneEnum zone) {
    this.zone = zone;
  }

  public Plug name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Reading Lamp", required = true, value = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Plug description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "The plug that controls the reading lamp", value = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Plug state(Boolean state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isState() {
    return state;
  }

  public void setState(Boolean state) {
    this.state = state;
  }

  public Plug updateDtime(OffsetDateTime updateDtime) {
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

  public Plug createDtime(OffsetDateTime createDtime) {
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
    Plug plug = (Plug) o;
    return Objects.equals(this.id, plug.id) &&
        Objects.equals(this.zone, plug.zone) &&
        Objects.equals(this.name, plug.name) &&
        Objects.equals(this.description, plug.description) &&
        Objects.equals(this.state, plug.state) &&
        Objects.equals(this.updateDtime, plug.updateDtime) &&
        Objects.equals(this.createDtime, plug.createDtime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, zone, name, description, state, updateDtime, createDtime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Plug {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    zone: ").append(toIndentedString(zone)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
