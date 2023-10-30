package racingcar.exception;

public class CarNameDuplicatedException extends IllegalArgumentException {
    private static final String messageFormat = "자동차 이름이 중복도었습니다. 중복된 이름 - %s";

    public CarNameDuplicatedException(String duplicatedCarName) {
        super(String.format(messageFormat, duplicatedCarName));
    }
}
