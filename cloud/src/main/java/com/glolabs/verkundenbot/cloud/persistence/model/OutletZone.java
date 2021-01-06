package com.glolabs.verkundenbot.cloud.persistence.model;

public enum OutletZone {
    //@formatter:off
    A("a"),
    B("b"),
    C("c"),
    D("d");
    //@formatter:on

    private final String label;

    private OutletZone(String label) { this.label = label; }

    public String getLabel() {
        return label;
    }
}