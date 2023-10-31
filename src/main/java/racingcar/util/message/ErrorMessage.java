package racingcar.util.message;

public enum ErrorMessage {

    REQUEST_ONLY_POSITIVE_NUMBER("자연수만 입력할 수 있습니다."),
    REQUEST_NOT_DUPLICATED("중복된 이름은 사용할 수 없습니다."),
    REQUEST_NAME_LIMIT("이름은 5글자 이하만 가능합니다."),
    REQUEST_NOT_EMPTY("이름을 공백으로 설정할 수 없습니다."),
    REQUEST_DELIMITER("쉼표(,)를 이용하여 이름을 구분해주세요."),
    ERROR("[ERROR] ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR.message + message;
    }
}
