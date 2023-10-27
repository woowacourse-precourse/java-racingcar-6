package racingcar.domain.car.validate;

public class NameLengthValidator {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH = "자동차 이름은 1 ~ 5자여야 합니다.";

    public static void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
