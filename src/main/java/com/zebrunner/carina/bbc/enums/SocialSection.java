package com.zebrunner.carina.bbc.enums;

public enum SocialSection {
    X_NEWS("news", "https://x.com/bbcworld"),
    X_BREAKING("breaking", "https://x.com/bbcbreaking"),
    X_SPORT("sport", "https://x.com/bbcsport"),
    X_EARTH("earth", "https://x.com/bbcearth"),
    X_TRAVEL("travel", "https://x.com/bbc_travel"),
    X_CULTURE("culture", "https://x.com/bbc_culture"),
    X_SELECT("select", "https://x.com/bbcselect"),

    FACEBOOK_NEWS("news", "https://www.facebook.com/bbcnews"),
    FACEBOOK_BREAKING("breaking", "https://www.facebook.com/bbcnews"),
    FACEBOOK_SPORT("sport", "https://www.facebook.com/BBCSport"),
    FACEBOOK_EARTH("earth", "https://www.facebook.com/bbcearth"),
    FACEBOOK_TRAVEL("travel", "https://www.facebook.com/BBCTravel"),
    FACEBOOK_CULTURE("culture", "https://www.facebook.com/BBCCulture"),
    FACEBOOK_SELECT("select", "https://www.facebook.com/bbcselect"),
    FACEBOOK_BBC_GLOBAL("BBC Global", "https://www.facebook.com/BBCGlobalFB"),

    INSTAGRAM_NEWS("news", "https://www.instagram.com/bbcnews"),
    INSTAGRAM_BREAKING("breaking", "https://www.instagram.com/bbcnews"),
    INSTAGRAM_SPORT("sport", "https://www.instagram.com/bbcsport"),
    INSTAGRAM_EARTH("earth", "https://www.instagram.com/bbcearth"),
    INSTAGRAM_TRAVEL("travel", "https://www.instagram.com/bbc_travel"),
    INSTAGRAM_CULTURE("culture", "https://www.instagram.com/bbc_culture"),
    INSTAGRAM_SELECT("select", "https://www.instagram.com/bbcselect"),
    INSTAGRAM_BBC_GLOBAL("BBC Global", "https://www.instagram.com/bbcglobal"),

    TIKTOK_NEWS("news","https://www.tiktok.com/@bbcnews"),
    TIKTOK_BREAKING("breaking", "https://www.tiktok.com/@bbcnews"),
    TIKTOK_SPORT("sport", "https://www.tiktok.com/@bbcsport"),
    TIKTOK_EARTH("earth", "https://www.tiktok.com/@bbcearth"),

    LINKEDIN_NEWS("news", "https://www.linkedin.com/company/bbc-news"),
    LINKEDIN_BREAKING("breaking", "https://www.linkedin.com/company/bbc-news"),

    YOUTUBE_NEWS("news", "https://www.youtube.com/bbcnews"),
    YOUTUBE_BREAKING("breaking", "https://www.youtube.com/bbcnews"),
    YOUTUBE_SPORT("sport", "https://www.youtube.com/bbcsport"),
    YOUTUBE_EARTH("earth", "https://www.youtube.com/bbcearth"),
    YOUTUBE_SELECT("select", "https://www.youtube.com/bbcselect"),
    YOUTUBE_BBC_GLOBAL("BBC Global", "https://www.youtube.com/@bbcglobal");

    private final String name;
    private final String url;

    SocialSection(String name, String url) {
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
