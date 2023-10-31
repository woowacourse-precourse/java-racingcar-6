package racingcar.exception;

// 오류가 발생할 경우, 사용자에게 전달되는 메세지를 관리하기 위한 열거형 클래스
public enum GameExceptionMessage {
    CAR_NAME_LENGTH("자동차의 이름은 최소 1자 이상, 5자 이하이어야 합니다."),
    CAR_NAME_CAN_NOT_BE_BLANK("자동차의 이름은 공백이 될 수 없습니다."),
    FREQUENCY_ONLY_NUMBER("이동 횟수는 숫자만 입력할 수 있습니다."),
    USER_INPUT_CAN_NOT_BE_BLANK("사용자의 입력은 공백이 될 수 없습니다.")
    ;

    private final String message;

    GameExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}