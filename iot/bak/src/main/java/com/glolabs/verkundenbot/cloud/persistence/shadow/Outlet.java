// package com.glolabs.verkundenbot.cloud.persistence.shadow;
//
// import java.util.Objects;
// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.annotation.JsonCreator;
// import com.fasterxml.jackson.annotation.JsonValue;
// import org.threeten.bp.OffsetDateTime;
// import org.springframework.validation.annotation.Validated;
// import javax.validation.Valid;
// import javax.validation.constraints.*;
//
// /**
//  * Outlet
//  */
// @Validated
// @Entity
// public class Outlet   {
//
//   @JsonProperty("id")
//   private Integer id = null;
//
//   /**
//    * Gets or Sets zone
//    */
//   public enum ZoneEnum {
//     A("a"),
//
//     B("b"),
//
//     C("c"),
//
//     D("d");
//
//     private String value;
//
//     ZoneEnum(String value) {
//       this.value = value;
//     }
//
//     @Override
//     @JsonValue
//     public String toString() {
//       return String.valueOf(value);
//     }
//
//     @JsonCreator
//     public static ZoneEnum fromValue(String text) {
//       for (ZoneEnum b : ZoneEnum.values()) {
//         if (String.valueOf(b.value).equals(text)) {
//           return b;
//         }
//       }
//       return null;
//     }
//   }
//   @JsonProperty("zone")
//   private ZoneEnum zone = null;
//
//   @JsonProperty("name")
//   private String name = null;
//
//   @JsonProperty("description")
//   private String description = null;
//
//   @JsonProperty("state")
//   private Boolean state = null;
//
//   @JsonProperty("update_dtime")
//   private OffsetDateTime updateDtime = null;
//
//   @JsonProperty("create_dtime")
//   private OffsetDateTime createDtime = null;
//
//   public Outlet id(Integer id) {
//     this.id = id;
//     return this;
//   }
//
//   /**
//    * Get id
//    * @return id
//   **/
//   public Integer getId() {
//     return id;
//   }
//
//   public void setId(Integer id) {
//     this.id = id;
//   }
//
//   public Outlet zone(ZoneEnum zone) {
//     this.zone = zone;
//     return this;
//   }
//
//   /**
//    * Get zone
//    * @return zone
//   **/
//   public ZoneEnum getZone() {
//     return zone;
//   }
//
//   public void setZone(ZoneEnum zone) {
//     this.zone = zone;
//   }
//
//   public Outlet name(String name) {
//     this.name = name;
//     return this;
//   }
//
//   /**
//    * Get name
//    * @return name
//   **/
//   public String getName() {
//     return name;
//   }
//
//   public void setName(String name) {
//     this.name = name;
//   }
//
//   public Outlet description(String description) {
//     this.description = description;
//     return this;
//   }
//
//   /**
//    * Get description
//    * @return description
//   **/
//   public String getDescription() {
//     return description;
//   }
//
//   public void setDescription(String description) {
//     this.description = description;
//   }
//
//   public Outlet state(Boolean state) {
//     this.state = state;
//     return this;
//   }
//
//   /**
//    * Get state
//    * @return state
//   **/
//   public Boolean isState() {
//     return state;
//   }
//
//   public void setState(Boolean state) {
//     this.state = state;
//   }
//
//   public Outlet updateDtime(OffsetDateTime updateDtime) {
//     this.updateDtime = updateDtime;
//     return this;
//   }
//
//   /**
//    * Get updateDtime
//    * @return updateDtime
//   **/
//   public OffsetDateTime getUpdateDtime() {
//     return updateDtime;
//   }
//
//   public void setUpdateDtime(OffsetDateTime updateDtime) {
//     this.updateDtime = updateDtime;
//   }
//
//   public Outlet createdTime(OffsetDateTime createdTime) {
//     this.createdTime = createdTime;
//     return this;
//   }
//
//   /**
//    * Get createDtime
//    * @return createDtime
//   **/
//   public OffsetDateTime getCreatedTime() {
//     return createdTime;
//   }
//
//   public void setCreatedTime(OffsetDateTime createdTime) {
//     this.createdTime = createdTime;
//   }
//
//
//   @Override
//   public boolean equals(java.lang.Object o) {
//     if (this == o) {
//       return true;
//     }
//     if (o == null || getClass() != o.getClass()) {
//       return false;
//     }
//     Outlet outlet = (Outlet) o;
//     return Objects.equals(this.id, outlet.id) &&
//         Objects.equals(this.zone, outlet.zone) &&
//         Objects.equals(this.name, outlet.name) &&
//         Objects.equals(this.description, outlet.description) &&
//         Objects.equals(this.state, outlet.state) &&
//         Objects.equals(this.updateDtime, outlet.updateDtime) &&
//         Objects.equals(this.createDtime, outlet.createDtime);
//   }
//
//   @Override
//   public int hashCode() {
//     return Objects.hash(id, zone, name, description, state, updateDtime, createDtime);
//   }
//
//   @Override
//   public String toString() {
//     StringBuilder sb = new StringBuilder();
//     sb.append("class Outlet {\n");
//
//     sb.append("    id: ").append(toIndentedString(id)).append("\n");
//     sb.append("    zone: ").append(toIndentedString(zone)).append("\n");
//     sb.append("    name: ").append(toIndentedString(name)).append("\n");
//     sb.append("    description: ").append(toIndentedString(description)).append("\n");
//     sb.append("    state: ").append(toIndentedString(state)).append("\n");
//     sb.append("    updateDtime: ").append(toIndentedString(updateDtime)).append("\n");
//     sb.append("    createDtime: ").append(toIndentedString(createDtime)).append("\n");
//     sb.append("}");
//     return sb.toString();
//   }
//
//   /**
//    * Convert the given object to string with each line indented by 4 spaces
//    * (except the first line).
//    */
//   private String toIndentedString(java.lang.Object o) {
//     if (o == null) {
//       return "null";
//     }
//     return o.toString().replace("\n", "\n    ");
//   }
// }
//
