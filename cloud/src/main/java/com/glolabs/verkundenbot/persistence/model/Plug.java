package com.glolabs.verkundenbot.persistence.model;

import java.util.Objects;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;


/**
 * Plug
 */
@Validated
@Entity
public class Plug   {

  @Id
  private Long id;

  private PlugZone zone;
  public enum PlugZone {
    A("a"),
    B("b"),
    C("c"),
    D("d");
  }

  private String name;

  private String description = null;

  private Boolean status = null;

  private LocalDateTime updatedTime = null;

  private LocalDateTime createdTime = null;

  public Plug id(Long id) {
    this.id = id;
    return this;
  }


}
