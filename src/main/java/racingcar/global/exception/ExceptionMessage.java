package racingcar.global.exception;

public enum ExceptionMessage {
    ERROR_PREFIX("[ERROR] ")
    ,NAMES_CANNOT_BE_NULL("이름은 null로 입력 불가합니다.")
    ,NAMES_FIRST_END_MUST_NOT_COMMA("이름 입력시 처음과 끝이 , 로 끝나면 안됩니다.")
    ,CONTINUOUS_COMMA_INVALID("연속으로 , 가 나오면 안됩니다.")
    ,CAR_NAME_LESS_THAN_FIVE_LETTER("자동차 이름 길이는 5글자 이내이어야 합니다.")
    ,NUMBER_CANNOT_BE_NULL("숫자는 null로 입력 불가능합니다.")
    ,NUMBER_MUST_BE_POSITIVE("양수의 숫자를 입력해주세요")
    ,INPUT_CANNOT_BE_NULL("입력은 null이 불가합니다.")
    ,INPUT_NUMBER("문자가 아닌 숫자를 입력해주세요")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
