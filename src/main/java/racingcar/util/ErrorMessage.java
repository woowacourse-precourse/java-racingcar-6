package racingcar.util;

public enum ErrorMessage {
    COMMA_IDENTIFIER_ERROR_MESSAGE("입력 구분을 ,로 하지 않았습니다."),
    CAR_NAME_LENGTH_ERROR_MESSAGE("자동차 이름은 길이는 5이하 입니다."),
    DUPLICATE_CAR_NAME_ERROR_MESSAGE("차 이름이 중복됐습니다."),
    CAR_NUM_ERROR_MESSAGE("차는 2대 이상 이여야 경주가 가능합니다."),
    TRY_NUM_TYPE_ERROR_MESSAGE("시도 횟수에 대한 입력이 정수가 아닙니다."),
    TRY_NUM_RANGE_ERROR_MESSAGE("시도 횟수가 옳바르지 않습니다. 양수로 입력해주세요.");


    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
