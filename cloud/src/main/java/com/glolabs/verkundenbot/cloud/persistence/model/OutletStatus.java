package com.glolabs.verkundenbot.cloud.persistence.model;

public enum OutletStatus {
    //@formatter:off
    ON(true),
    OFF(false);
    //@formatter:on

    private final boolean label;

    private OutletStatus(boolean label) { this.label = label; }

    public boolean getLabel() {
        return label;
    }
}