package racingcar.util;

public class ErrorMessage {
    public static final String ERROR_NOT_EMPTY = "비어있는 값을 입력할 수 없습니다.";
    public static final String ERROR_WRONG_CARS_NAME = "',' 뒤에 자동차의 이름을 입력해야 합니다.";
    public static final String ERROR_WRONG_CAR_NAME = "자동차의 이름은 5글자 이하로 입력해야 합니다.";
    public static final String ERROR_WRONG_NUMBER_OF_RACE = "시도 횟수는 1 이상의 숫자로 입력해야 합니다.";

    private ErrorMessage() {
    }
}