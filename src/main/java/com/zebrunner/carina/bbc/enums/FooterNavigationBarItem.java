package com.zebrunner.carina.bbc.enums;

public enum FooterNavigationBarItem {
    HOME("Home", "/"),
    NEWS("News", "/news"),
    SPORT("Sport", "/sport"),
    BUSINESS("Business", "/business"),
    INNOVATION("Innovation", "/innovation"),
    CULTURE("Culture", "/culture"),
    ARTS("Arts", "/arts"),
    TRAVEL("Travel", "/travel"),
    EARTH("Earth", "/future-planet"),
    VIDEO("Video", "/video"),
    LIVE("Live", "/live"),
    AUDIO("Audio", "/sounds"),
    WEATHER("Weather", "/weather"),
    BBCSHOP("BBC Shop", "https://shop.bbc.com/");

    private String name;
    private String url;

    FooterNavigationBarItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
