package racingcar.model;

public final class ExceptionMessage {
    public static final String BLANK_NAME_EXCEPTION_MESSAGE = "공백 문자로는 이름을 입력할 수 없습니다.";
    public static final String POSITION_UNDER_LIMIT_FORMAT_MESSAGE = "자동차의 위치는 %d보다 작을 수 없습니다.";
    public static final String CAR_NAME_OVER_LIMIT_FORMAT_MESSAGE = "자동차 이름은 %d자를 초과할 수 없습니다.";
    public static final String EMPTY_CAR_GROUP_EXCEPTION_MESSAGE = "자동차 그룹은 비어있을 수 없습니다.";
    public static final String DUPLICATE_CAR_GROUP_EXCEPTION_MESSAGE = "자동차 그룹에 중복된 이름이 존재합니다.";

    private ExceptionMessage() {
    }
}
