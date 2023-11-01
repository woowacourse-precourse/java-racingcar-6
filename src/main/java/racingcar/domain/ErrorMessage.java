package racingcar.domain;

public enum ErrorMessage {
    EMPTY_INPUT_ERROR("입력된 값이 없습니다."),
    BLANK_INPUT_ERROR("','로 구분되는 자동차 이름은 1글자 이상이어야 합니다."),
    LAST_CAR_NAME_ERROR("입력한 자동차 이름 마지막에 ','를 입력할 수 없습니다."),
    CAR_NAME_RANGE_ERROR("입력된 자동차 이름은 5글자까지 가능합니다.(이름은 5자 이하만 가능)"),
    CONVERT_NUMBER_ERROR("입력된 값이 숫자 형태가 아닙니다.(0~9 사이의 값만 입력 가능)"),
    LESS_THEN_ONE_ERROR("입력된 값이 1보다 작을 수 없습니다."),
    GREATER_THEN_MAX_VALUE_ERROR("입력된 값이 MAX_VALUE보다 클 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getGreaterMaxValueThen(int maxValue) {
        return message.replace("MAX_VALUE", String.valueOf(maxValue));
    }
}
