package racingcar.consts;

public enum ErrorMessages {
    WRONG_CAR_TYPES_MESSAGE("[ERROR] 2종류 이상의 차량을 입력해주세요."),
    WRONG_CAR_NAME_LENGTH_MESSAGE("[ERROR] 차량 이름은 1글자 이상 5글자 이하 입니다."),
    DUPLICATION_CAR_NAME_MESSAGE("[ERROR] 차량 이름에 중복이 있습니다.");

    private final String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
