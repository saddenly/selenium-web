package com.zebrunner.carina.bbc.enums;

public enum Language {
    RUSSIAN("russian", "Russian НА РУССКОМ"),
    UKRAINIAN("ukrainian", "Ukrainian УКРАЇНСЬКA"),
    KYRGYZ("kyrgyz", "Kyrgyz Кыргыз"),
    FRENCH("french", "French AFRIQUE"),
    SERBIAN("serbian", "Serbian  NA SRPSKOM");

    private final String language;
    private final String url;

    Language(String language, String url) {
        this.language = language;
        this.url = url;
    }

    public String getLanguage() {
        return language;
    }

    public String getUrl() {
        return url;
    }
}
