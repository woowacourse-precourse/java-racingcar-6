package racingcar.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameConstant {
    TRUE("true"),
    FALSE("false"),
    MAXIMUM_LENGTH_OF_CAR_NAME("5"),
    DELIMITER(",");

    private final String content;
    public static final Pattern NUMBER_PATTERN = Pattern.compile("(\\+|-)?[0-9]+");
    public static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("\\+?[0-9]+");
    public static final Pattern TRUE_PATTERN = Pattern.compile("true");
    public static final Pattern FALSE_PATTERN = Pattern.compile("false");

    GameConstant(String content) {
        this.content = content;
    }

    public Boolean getContentToBoolean() {
        Matcher trueMatcher = TRUE_PATTERN.matcher(this.content);
        Matcher falseMatcher = FALSE_PATTERN.matcher(this.content);

        if (trueMatcher.matches()) {
            return true;
        }

        if (falseMatcher.matches()) {
            return false;
        }

        throw new IllegalCallerException("함수가 올바르지 않은 형식으로 사용되었습니다.");
    }

    public Integer getContentToInteger() {
        Matcher matcher = NUMBER_PATTERN.matcher(this.content);

        if (matcher.matches()) {
            return Integer.parseInt(this.content);
        }

        throw new IllegalCallerException("함수가 올바르지 않은 형식으로 사용되었습니다.");
    }

    public String getContent() {
        return this.content;
    }
}
