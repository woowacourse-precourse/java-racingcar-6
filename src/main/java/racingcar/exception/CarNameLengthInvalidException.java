package racingcar.exception;

public class CarNameLengthInvalidException extends IllegalArgumentException {

    private static final String messageFormat = "자동차 이름의 길이가 올바르지 않습니다. (%s)의 길이가 %d입니다.";

    public CarNameLengthInvalidException(String invalidName) {
        super(String.format(messageFormat, invalidName, invalidName.length()));
    }
}
