package validation;

public enum ErrorMessage {
    NAME_LENGTH_ERROR("자동차 이름은 1이상 5이하만 가능합니다."),
    NAME_DUPLICATE_ERROR("자동차 이름은 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
