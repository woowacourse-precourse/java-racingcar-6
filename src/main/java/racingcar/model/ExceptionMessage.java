package racingcar.model;

public final class ExceptionMessage {
    public static final String BLANK_NAME_EXCEPTION_MESSAGE = "공백 문자로는 이름을 입력할 수 없습니다.";
    public static final String POSITION_UNDER_LIMIT_FORMAT_MESSAGE = "자동차의 위치는 %d보다 작을 수 없습니다.";
    public static final String CAR_NAME_OVER_LIMIT_FORMAT_MESSAGE = "자동차 이름은 %d자를 초과할 수 없습니다.";
    public static final String EMPTY_CAR_GROUP_EXCEPTION_MESSAGE = "자동차 그룹은 비어있을 수 없습니다.";
    public static final String DUPLICATE_CAR_GROUP_EXCEPTION_MESSAGE = "자동차 그룹에 중복된 이름이 존재합니다.";
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자로 변환 가능한 문자만 가능합니다.";
    public static final String TRY_COUNT_RANGE_EXCEPTION_MESSAGE = "시도 횟수는 %d 이상 %d 이하의 정수만 가능합니다.";
    public static final String EMPTY_WINNER_GROUP_EXCEPTION_MESSAGE = "우승자를 찾기 위한 자동차 그룹이 비어있습니다.";
    public static final String EMPTY_RACE_HISTORY_EXCEPTION_MESSAGE = "경주 기록이 없습니다.";

    private ExceptionMessage() {
    }
}
