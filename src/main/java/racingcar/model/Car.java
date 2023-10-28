package racingcar.model;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MOVING_DISTANCE_PER_ACCELERATE = 1;
    private static final String EMPTY_NAME = "";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_EMPTY_NAME = "자동차의 이름이 존재하지 않습니다.";
    private static final String ERROR_INVALID_NAME_LENGTH = "자동차의 이름은 5자 이하만 가능합니다.";

    private String name;
    private int totalMovingDistance;

    public Car(String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
        this.totalMovingDistance = 0;
    }

    public void accelerate(CarAccelerator carAccelerator) {
        if (carAccelerator.shouldAccelerate()) {
            totalMovingDistance += MOVING_DISTANCE_PER_ACCELERATE;
        }
    }

    private void validateEmptyName(String name) {
        if (name.equals(EMPTY_NAME)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_EMPTY_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int getTotalMovingDistance() {
        return totalMovingDistance;
    }
}
