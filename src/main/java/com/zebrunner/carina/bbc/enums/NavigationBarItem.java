package com.zebrunner.carina.bbc.enums;

public enum NavigationBarItem {
    HOME("Home","/"),
    NEWS("News","/news"),
    SPORT("Sport","/sport"),
    BUSINESS("Business","/business"),
    INNOVATION("Innovation", "/innovation"),
    CULTURE("Culture", "/culture"),
    ARTS("Arts", "/arts"),
    TRAVEL("Travel", "/travel"),
    EARTH("Earth", "/future-planet"),
    VIDEO("Video", "/video"),
    LIVE("Live", "/live"),;

    private final String name;
    private final String path;

    NavigationBarItem(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
