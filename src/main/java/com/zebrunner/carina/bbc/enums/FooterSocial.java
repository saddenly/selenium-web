package com.zebrunner.carina.bbc.enums;

import java.util.List;

public enum FooterSocial {
    X("x", List.of(SocialSection.X_NEWS,
            SocialSection.X_BREAKING,
            SocialSection.X_SPORT,
            SocialSection.X_EARTH,
            SocialSection.X_TRAVEL,
            SocialSection.X_CULTURE,
            SocialSection.X_SELECT)),
    FACEBOOK("facebook", List.of(SocialSection.FACEBOOK_NEWS,
            SocialSection.FACEBOOK_BREAKING,
            SocialSection.FACEBOOK_SPORT,
            SocialSection.FACEBOOK_EARTH,
            SocialSection.FACEBOOK_TRAVEL,
            SocialSection.FACEBOOK_CULTURE,
            SocialSection.FACEBOOK_SELECT,
            SocialSection.FACEBOOK_BBC_GLOBAL)),
    INSTAGRAM("instagram", List.of(SocialSection.INSTAGRAM_NEWS,
            SocialSection.INSTAGRAM_BREAKING,
            SocialSection.INSTAGRAM_SPORT,
            SocialSection.INSTAGRAM_EARTH,
            SocialSection.INSTAGRAM_TRAVEL,
            SocialSection.INSTAGRAM_CULTURE,
            SocialSection.INSTAGRAM_SELECT,
            SocialSection.INSTAGRAM_BBC_GLOBAL)),
    TIKTOK("tiktok", List.of(SocialSection.TIKTOK_NEWS,
            SocialSection.TIKTOK_BREAKING,
            SocialSection.TIKTOK_SPORT,
            SocialSection.TIKTOK_EARTH)),
    LINKEDIN("linkedin", List.of(SocialSection.LINKEDIN_NEWS,
            SocialSection.LINKEDIN_BREAKING)),
    YOUTUBE("youtube", List.of(SocialSection.YOUTUBE_NEWS,
            SocialSection.YOUTUBE_BREAKING,
            SocialSection.YOUTUBE_SPORT,
            SocialSection.YOUTUBE_EARTH,
            SocialSection.YOUTUBE_SELECT,
            SocialSection.YOUTUBE_BBC_GLOBAL));

    private final String name;
    private final List<SocialSection> section;

    FooterSocial(String name, List<SocialSection> section) {
        this.name = name;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public List<SocialSection> getSection() {
        return section;
    }
}
