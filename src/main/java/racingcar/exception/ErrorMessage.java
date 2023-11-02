package racingcar.exception;

public enum ErrorMessage {
    //car
    INSUFFICIENT_CAR_SIZE_ERROR("[ERROR] 게임 진행을 위해 자동차 이름을 최소 2개 이상 입력해주세요."),

    //carName
    CAR_NAME_BLANK_ERROR("[ERROR] 자동차 이름은 공백일 수 없습니다. 자동차 이름을 입력해주세요."),
    CAR_NAME_DELIMITER_ERROR("[ERROR] 자동차 이름을 쉼표로 구분하여 입력해주세요."),
    CAR_NAME_MINIMUM_LENGTH_ERROR("[ERROR] 각 자동차의 이름은 공백이 아니어야 하고, 최소 한글자 이상 이어야 합니다."),
    CAR_NAME_LENGTH_EXCEEDED_ERROR("[ERROR] 각 자동차의 이름을 5글자 이하로 입력해주세요."),
    DUPLICATE_CAR_NAME_ERROR("[ERROR] 서로 다른 자동차 이름을 입력해주세요."),

    //totalRound
    INVALID_TOTAL_ROUND_ERROR("[ERROR] 게임을 진행할 총 횟수는 1 이상의 숫자로 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        message = message;
    }

    public String getMessage() {
        return message;
    }
}
