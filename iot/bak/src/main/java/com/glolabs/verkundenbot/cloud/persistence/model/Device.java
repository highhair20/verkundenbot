package com.glolabs.verkundenbot.cloud.persistence.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.type.UUIDCharType;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

/**
 * Device
 */
@Validated
@Entity
public class Device {

    @Id
    @Type(type="uuid-char")
    private UUID id;

    private String name = null;
    private String description = null;
    private DateTime createdTime = null;
    private DateTime updatedTime = null;

//    @OneToMany(mappedBy="device")
//    private Set<Outlet> outlets;

    public Device() {
    }

    public Device(UUIDCharType id) {
      this.id = id;
//      this.outlets = new HashSet<>();
    }


//    public Device(Device device) {
//        this(device.getName());
//        this.outlets = device.getOutlets()
//            .stream()
//                .collect(Collectors.toSet());
//    }

    public UUIDCharType getId() {
        return id;
    }

    public void setId(UUIDCharType id) {
        this.id = id;
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

//    public Set<Outlet> getOutlets() {
//        return outlets;
//    }

//    public void setOutlets(Set<Outlet> outlets) {
//        this.outlets = outlets;
//    }
//
//    public void addOutlet(Outlet outlet) {
//        this.outlets.add(outlet);
//    }

    public DateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(DateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public DateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return getId().equals(device.getId()) &&
                Objects.equals(getName(), device.getName()) &&
                Objects.equals(getDescription(), device.getDescription()) &&
//                Objects.equals(getOutlets(), device.getOutlets()) &&
                Objects.equals(getUpdatedTime(), device.getUpdatedTime()) &&
                Objects.equals(getCreatedTime(), device.getCreatedTime());
    }

    @Override
    public int hashCode() {
//        return Objects.hash(getId(), getName(), getDescription(), getOutlets(), getUpdatedTime(), getCreatedTime());
        return 1234;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
//                ", outlets=" + outlets +
                ", updatedTime=" + updatedTime +
                ", createdTime=" + createdTime +
                '}';
    }
}
