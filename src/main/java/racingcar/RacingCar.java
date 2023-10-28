package racingcar;

public class RacingCar {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private static final int VELOCITY = 1;
    private static final int MIN_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    public RacingCarStatus getInformation() {
        return RacingCarStatus.of(name, position);
    }

    public void checkAndMoveForward(int chosenNumber) {
        if (checkMoveForwardCondition(chosenNumber)) {
            moveForward();
        }
    }

    private boolean checkMoveForwardCondition(int chosenNumber) {
        return chosenNumber >= MIN_THRESHOLD;
    }

    private void moveForward() {
        this.position += VELOCITY;
    }

    private void validateName(String name) {
        validateNameLengthInRange(name);
    }

    private void validateNameLengthInRange(String name) {
        validateNameLengthLongerThanMinimumValue(name);
        validateNameLengthShorterThanMaximumValue(name);
    }

    private void validateNameLengthShorterThanMaximumValue(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLengthLongerThanMinimumValue(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
