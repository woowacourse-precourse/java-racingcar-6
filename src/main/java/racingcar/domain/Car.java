package racingcar.domain;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_ERROR_MESSAGE = "차량 이름의 길이 제한은 1~5입니다.";


    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
        validate();
    }

    public String getName() {
        return name;
    }

    private void moveForward() {
        distance++;
    }

    private void validateIsCarNameEmpty() {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }
    private void validateIsCarNameExceedMaxLength() {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void validate() {
        validateIsCarNameEmpty();
        validateIsCarNameExceedMaxLength();
    }

}
