package racingcar.exception.car;

public class InvalidCarNamesInputException extends IllegalArgumentException {
    public static final String INVALID_CAR_NAMES_INPUT = "유효하지 않은 양식입니다.\n차 이름 양식은 ,로 구분해주세요.";

    public InvalidCarNamesInputException() {
        super(INVALID_CAR_NAMES_INPUT);
    }
}
