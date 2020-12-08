package com.glolabs.verkundenbot.persistence.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;


/**
 * Outlet
 */
@Validated
@Entity
public class Outlet {

  @Id
  private Long id;

  private OutletZone zone;
  public enum OutletZone {
    A,
    B,
    C,
    D;
  }

  private String name;
  private String description = null;
  private Boolean status = null;
  private LocalDateTime updatedTime = null;
  private LocalDateTime createdTime = null;

  public Outlet id(Long id) {
    this.id = id;
    return this;
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

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
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






}
