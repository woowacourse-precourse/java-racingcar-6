package racingcar.domain.input.error;

public enum InputError {

    EXCEEDED_MAXIMUM_ERROR("입력할 수 있는 최대를 넘었습니다."),
    MUST_BE_NUMBER("입력값은 숫자여야 합니다."),

    DOES_NOT_MATCH_WITH_TRIAL_AMOUNT("입력한 이름의 개수가 게임 ");

    final String message;

    InputError(String message) {
        this.message = message;
    }
}
