package racingcar.domain.car;

public final class NameConstants {
    public static final int MAX_LENGTH = 5;
    public static final String ALPHABET_PATTERN = "^[a-zA-Z]+$";
    public static final String LENGTH_IS_OVER_MAX = String.format("자동차 이름을 %d글자 이하로 입력하세요.", MAX_LENGTH);
    public static final String NOT_ALPHABETIC = "자동차 이름을 영어 대소문자로 입력하세요.";
    public static final String NAME_DUPLICATED = "서로 다른 이름을 입력하세요.";
}
