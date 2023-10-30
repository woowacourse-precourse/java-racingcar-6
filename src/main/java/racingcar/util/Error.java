package racingcar.util;

public enum Error {
    LONG_CAR_NAME_ERROR("자동차 이름이 5자를 초과했습니다."),
    BLANK_CAR_NAME_ERROR("자동차 이름을 공백으로 입력하였습니다."),
    NOT_NUMBER_INPUTTED("숫자로 입력하셔야합니다."),
    NOT_NATURAL_NUMBER("입력한 숫자가 자연수가 아닙니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
