package racingcar.exception;

public class CarListEmptyException extends IllegalArgumentException {

    private static final String exceptionMessage = "차량 리스트가 비어있습니다.";

    public CarListEmptyException() {
        super(exceptionMessage);
    }
}
