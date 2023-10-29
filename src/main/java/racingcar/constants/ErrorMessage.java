package racingcar.constants;

public enum ErrorMessage {

    ERROR_DUPLICATED_NAME("자동차의 이름은 중복될 수 없습니다."),
    ERROR_NAME_LENGTH("자동차의 이름은 5자 이하여야 합니다."),
    ERROR_IS_BLANK("자동차의 이름에 공백은 포함될 수 없습니다."),

    ERROR_IS_NOT_NATURAL_NUMBER("자연수만 입력 가능합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
