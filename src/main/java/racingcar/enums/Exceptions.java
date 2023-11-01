package racingcar.enums;

public enum Exceptions {
    CAR_NAME_IS_OVER_5("자동차 이름은 5글자 이하여야 합니다."),
    CAR_NAME_IS_BLANK("빈 자동차 이름은 입력할 수 없습니다."),
    TRY_NUMBER_IS_UNDER_0("시도 횟수는 0 이상이어야 합니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    TRY_NUMBER_IS_INTEGER("시도 횟수는 숫자여야 합니다."),
    CAR_NAME_IS_NOT_NUMBER("자동차 이름은 숫자가 아니여야 합니다."),
    ;

    private String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
