package util;

public enum Exception {
    INVALID_CHARACTER_FORMAT("입력은 영문자, 한글, 숫자, 빈 칸, 또는 쉼표(,)만 가능합니다."),
    CAR_NAME_NOT_EMPTY("자동차 이름을 입력하세요."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하만 가능합니다."),
    CAR_LIST_SIZE_TOO_LITTLE("자동차가 2대 이상이어야 합니다."),
    INVALID_NUMBER_FORMAT("올바른 숫자를 입력하세요."),
    NUMBER_OF_ATTEMPT_TOO_LITTLE("시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
