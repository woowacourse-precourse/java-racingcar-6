package racingcar.Utils;

public enum ErrorMessage {
    CAR_NAME_ONLY_FIVE_BELOW("[ERROR] 자동차 이름은 5자 이하만 가능합니다."),
    USER_INSERT_ONLY_NUMBER("[ERROR] 시도할 회수는 숫자만 입력 가능합니다."),
    USER_INSERT_MIN_NUMBER_ONE("[ERROR]시도 횟수는 4 이상의 숫자여야 한다."),
    USER_INSERT_NOT_DUPLICATION("[ERROR] 자동차의 이름은 중복될수 없습니다."),
    USER_INSERT_NOT_BLANK("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
