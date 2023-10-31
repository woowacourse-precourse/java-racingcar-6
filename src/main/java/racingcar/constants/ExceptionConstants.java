package racingcar.constants;

public class ExceptionConstants {
    public static final String INVALID_NAME_SHORT = "1글자 이상의 이름을 입력하십시오.";
    public static final String INVALID_NAME_LONG = "5글자 이하의 이름을 입력하십시오.";
    public static final String INVALID_NAME_BLANK = "이름에 글자를 포함하여 주십시오";
    public static final String INVALID_NAME_ZERO = "1개 이상의 이름을 입력하십시오.";
    public static final String DUPLICATE_NAME = "중복된 이름을 입력하셨습니다.";
    public static final String EXCEED_NAME_COUNT = GameConstants.MAX_NAME_COUNT + "명 이하의 이름만 입력 가능합니다.";
    public static final String MISSING_COMMA = ",로 이름을 구분해주세요";
    public static final String INVALID_DIGIT_INPUT = "숫자만 입력 가능합니다.";
    public static final String EXCEED_DIGIT_INPUT = GameConstants.MAX_TRY_NUM + "보다 작은 숫자만 입력 가능합니다.";
    public static final String INVALID_ZERO_DIGIT = "0이상의 숫자를 입력해주세요";
}