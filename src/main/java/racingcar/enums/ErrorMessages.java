package racingcar.enums;

public enum ErrorMessages {
    NULL_ERROR("[ERROR] 입력이 들어오지 않았습니다."),
    EMPTY_ERROR("[ERROR] 공백으로 이루어져있습니다. 문자을 포함하여 작성하여 주세요."),
    SEPARATOR_ERROR("[ERROR] 구분자가 올바르지 못한 위치에서 사용되었습니다."),
    OVER_LENGTH_ERROR(String.format("[ERROR] 이름은 %d글자 이하 여야 합니다.",
            Common.CAR_NAME_MAX_LENGTH.getIntValue())),
    NUMERIC_ERROR("[ERROR] 숫자형식이에 맞지 않는 문자를 입력하였습니다."),
    UNDER_NUMBER_ERROR("[ERROR] 양수를 적어주세요."),
    REGISTER_ERROR("[ERROR] 등록되지 않은 이름입니다."),
    DUPLICATE_NAME_ERROR("[ERROR] 중복되는 이름이 존재합니다.")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
