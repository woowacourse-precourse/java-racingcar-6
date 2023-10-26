package racingcar.domain;

public class Car {

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int FORWARD_BASE_NUMBER = 4;
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "5자 이하의 이름만 가능합니다.";
    private static final String EMPTY_SPACE = "";
    private static final String FORWARD_MOVEMENT_INDICATOR = "-";
    private static final String SEPARATOR = " : ";

    private final String name;
    private String location = EMPTY_SPACE;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    public String move(int randomNumber) {
        if (isForward(randomNumber)) {
            location += FORWARD_MOVEMENT_INDICATOR;
        }
        return name + SEPARATOR + location;
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= FORWARD_BASE_NUMBER;
    }

    private void validateCarNameLength(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
