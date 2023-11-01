package racingcar.view;

public enum ErrorMessage {
    BLANK_STRING("입력 문자열이 비어 있습니다."),
    REQUIRE_LENGTH_UNDER_FIVE("자동차 이름을 5자 이하로 입력해주세요."),
    REQUIRE_INTEGER_TYPE("자동차 이름을 정수 값을 입력해주세요."),
    REQUIRE_NOT_BLANK("자동차 이름을 공백 없이 입력해주세요."),
    REQUIRE_NOT_DUPLICATE("자동차 이름을 중복 없이 입력해주세요."),
    REQUIRE_OVER_ONE("1회 이상 게임이 진행 되어야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String message() {
        return errorMessage;
    }
}
