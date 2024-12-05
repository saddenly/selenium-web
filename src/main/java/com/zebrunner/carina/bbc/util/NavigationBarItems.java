package com.zebrunner.carina.bbc.util;

public enum NavigationBarItems {
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

    NavigationBarItems(String name, String path) {
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
