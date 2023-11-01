package racingcar.view.input.error;

public enum InputError {

    EXCEEDED_MAXIMUM_ERROR("이름의 길이는 최대 %s, 최소 %s 입니다."),
    MUST_BE_NUMBER("입력값은 숫자여야 합니다."),
    NOT_EXCEED_MINIMUM_AMOUNT("이름을 2개 이상은 입력해야 합니다."),
    TRIAL_MUST_NOT_BLANK("횟수를 입력하지 않았습니다.");

    final String message;

    InputError(String message) {
        this.message = message;
    }
}
