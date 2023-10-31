package racingcar.constants;

public enum ErrorMessage {

    ERROR_DUPLICATED_NAME("자동차의 이름은 중복될 수 없습니다."),
    ERROR_NAME_LENGTH("자동차의 이름은 공백 포함 5자 이하여야 합니다."),
    ERROR_IS_BLANK("자동차의 이름은 공백으로만 입력하거나 빈 값으로 입력할 수 없습니다."),
    ERROR_CARS_SIZE("게임에 참여하는 자동차는 2대 이상이어야 합니다."),

    ERROR_IS_NOT_NATURAL_NUMBER("자연수만 입력 가능합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
