package racingcar.constants;

public enum Messages {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 " + GameInfo.SEPARATOR_NAME + "(" + GameInfo.SEPARATOR
        + ") 기준으로 구분)"),
    INPUT_CAR_NAMES_ERROR("자동차 이름은 " + GameInfo.SEPARATOR_NAME + "로 구분되며 공백은 허용되지 않습니다.");


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
