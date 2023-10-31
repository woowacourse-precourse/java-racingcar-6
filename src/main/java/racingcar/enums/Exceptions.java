package racingcar.enums;

public enum Exceptions {
    CAR_NAME_IS_OVER_5("자동차 이름은 5글자 이하여야 합니다."),
    CAR_NAME_IS_BLANK("빈 자동차 이름은 입력할 수 없습니다."),
    TRY_NUMBER_IS_UNDER_0("시도 횟수는 0 이상이어야 합니다.")
    ;

    private String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
