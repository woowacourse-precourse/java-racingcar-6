package racingcar.constant;

public enum ErrorMessage {
    INVALID_RACING_CAR_NAME_COUNT("올바르지 않은 자동차 갯수입니다. 2~5개 사이의 자동차만 참여 가능합니다."),
    DUPLICATED_RACING_CAR_NAME("중복된 자동차 이름이 존재합니다."),
    INVALID_ROUND_COUNT("올바르지 않은 라운드 수 입니다. 1~30 사이의 입력만 가능합니다."),
    INVALID_CAR_NAME("올바르지 않은 자동차 이름입니다. 자동차 이름은 공백 포함 5자 이하여야 하며, 공백으로만 이루어질 수 없습니다.")
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
