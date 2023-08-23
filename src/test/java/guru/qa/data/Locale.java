package guru.qa.data;

public enum Locale {
    ENGLISH ("English"),
    РУССКИЙ ("Русский"),
    DEUTSCH ("Deutsch");

    private final String language;
        Locale(String value) {
        this.language = value;
    }

    public String getLanguage() {
        return language;
    }
}
