package com.zebrunner.carina.bbc.pages;

public enum NavigationBarItems {
    HOME("home","/"),
    NEWS("news","/news"),
    SPORT("sport","/sport"),
    BUSINESS("business","/business"),
    INNOVATION("innovation", "/innovation"),
    CULTURE("culture", "/culture"),
    ARTS("arts", "/arts"),
    TRAVEL("travel", "/travel"),
    EARTH("earth", "/future-planet"),
    VIDEO("video", "/video"),
    LIVE("live", "/live");

    private final String url;
    private final String path;

    NavigationBarItems(String url, String path) {
        this.url = url;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return url;
    }
}
