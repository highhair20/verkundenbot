package com.glolabs.verkundenbot.cloud.persistence.model;

import org.threeten.bp.LocalDateTime;

import javax.persistence.*;

import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Objects;


/**
 * Outlet
 */
@Validated
@Entity
public class Outlet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description = null;
  private OutletZone zone;
  private OutletStatus status;

  private LocalDateTime updatedTime = null;
  private LocalDateTime createdTime = null;

//  @ManyToOne
//  @JoinColumn(name="device_id")
//  private Device device;

  public Outlet() {

  }

  public Outlet(String name) {
    this.name = name;
  }

  public Outlet(String name, String description, OutletZone zone, OutletStatus status) {
    this.name = name;
    this.description = description;
    this.zone = zone;
    this.status = status;
  }

  public Outlet(Outlet outlet) {
    this(outlet.getName(), outlet.getDescription(), outlet.getZone(), outlet.getStatus());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OutletZone getZone() {
    return zone;
  }

  public void setZone(OutletZone zone) {
    this.zone = zone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OutletStatus getStatus() {
    return status;
  }

  public void setStatus(OutletStatus status) {
    this.status = status;
  }

  public LocalDateTime getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(LocalDateTime updatedTime) {
    this.updatedTime = updatedTime;
  }

  public LocalDateTime getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(LocalDateTime createdTime) {
    this.createdTime = createdTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Outlet)) return false;
    Outlet outlet = (Outlet) o;
    return getId().equals(outlet.getId()) &&
            getZone() == outlet.getZone() &&
            getName().equals(outlet.getName()) &&
            Objects.equals(getDescription(), outlet.getDescription()) &&
            Objects.equals(getStatus(), outlet.getStatus()) &&
            Objects.equals(getUpdatedTime(), outlet.getUpdatedTime()) &&
            getCreatedTime().equals(outlet.getCreatedTime());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getZone(), getName(), getDescription(), getStatus(), getUpdatedTime(), getCreatedTime());
  }

  @Override
  public String toString() {
    return "Outlet{" +
            "id=" + id +
            ", zone=" + zone +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", status=" + status +
            ", updatedTime=" + updatedTime +
            ", createdTime=" + createdTime +
            '}';
  }
}
