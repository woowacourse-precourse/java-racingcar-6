package racingcar.utils;

public class EnglishMatcher {

    private static final String ENGLISH_MATCHER = "^[a-zA-Z]*$";

    private EnglishMatcher() {
    }

    public static boolean isEnglish(String input) {
        return input.matches(ENGLISH_MATCHER);
    }
}
