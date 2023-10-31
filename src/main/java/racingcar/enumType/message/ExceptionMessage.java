package racingcar.enumType.message;

public enum ExceptionMessage {

    LENGTH_MESSAGE("자동차 이름의 길이는 1 ~ 5 여야합니다.")
    , DUPLICATE_MESSAGE("중복된 값을 입력할 수 없습니다.")
    , SPACE_MESSAGE("이름에 공백이 들어가면 안됩니다.")
    , EMPTY_MESSAGE("이름에 빈 값이 들어올 수 없습니다.")
    , NULL_MESSAGE("값에 null이 들어올 수 없습니다.")
    , COMMA_MESSAGE("자동차 이름들은 , 로 구분 되어야 합니다.")
    , NUMERIC_FORMAT_MESSAGE("숫자를 입력해야 합니다.")
    , RANGE_MESSAGE("1 이상의 숫자를 입력해야 합니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
