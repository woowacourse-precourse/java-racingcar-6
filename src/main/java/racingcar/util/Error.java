package racingcar.util;

public enum Error {
    LONG_CAR_NAME_ERROR("자동차 이름이 5자를 초과했습니다."),
    BLANK_CAR_NAME_ERROR("자동차 이름을 공백으로 입력하였습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
