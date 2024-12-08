package com.zebrunner.carina.bbc.enums;

public enum NavigationBarItem {
    HOME("1","/"),
    NEWS("2","/news"),
    SPORT("3","/sport"),
    BUSINESS("4","/business"),
    INNOVATION("5", "/innovation"),
    CULTURE("6", "/culture"),
    ARTS("7", "/arts"),
    TRAVEL("8", "/travel"),
    EARTH("9", "/future-planet"),
    VIDEO("10", "/video"),
    LIVE("11", "/live"),;

    private final String index;
    private final String path;

    NavigationBarItem(String index, String path) {
        this.index = index;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getIndex() {
        return index;
    }
}
