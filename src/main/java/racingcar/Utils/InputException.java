package racingcar.Utils;

public enum InputException {
    WRONG_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    WRONG_CAR_NAME_PATTERN("자동차 이름은 영어 소문자(a-z)와 숫자(0-9)의 조합만 가능합니다."),
    EXCEED_CAR_NUM("자동차의 대수는 최소 1대에서 최대 10대 가능합니다."),
    DUPLICATE_CAR_NAME("중복되는 자동차 이름이 있습니다."),
    NOT_NUMBER("시도할 횟수는 숫자만 입력 가능합니다."),
    EXCEED_TRY_COUNT("시도할 횟수는 1부터 100까지 가능합니다.");

    private String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
