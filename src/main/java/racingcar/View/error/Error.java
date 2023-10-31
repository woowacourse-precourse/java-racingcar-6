package racingcar.View.error;

public enum Error {

    ROUND_COUNT_MAXIMUM_ERROR("라운드 수는 최대 5회 입니다."),
    ROUND_COUNT_UNDEFIND_ERROR("라운드 값이 입력 되지 않았습닏다."),

    USERNAME_MAXIMUM_ERROR("유저 이름은 최대 5글자 입니다."),

    USERNAME_UNDEFINED_ERROR("유저 이름이 입력 되지 않았습니다.");

    final String message;

    Error(String message) {
        this.message = message;
    }
}