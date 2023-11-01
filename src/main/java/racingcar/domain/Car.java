package racingcar.domain;

public final class Car {

    private final int MAX_CAR_NAME_LENGTH = 5;
    private final String MAX_CAR_NAME_ERROR_MESSAGE = String.format(
            "Car name length must be less than %d characters",
            MAX_CAR_NAME_LENGTH
    );
    private final String name;
    private final MovableStrategy movableStrategy;

    private final int movementDistance;

    public Car(String name, MovableStrategy movableStrategy) {
        validateCarName(name);
        this.name = name;
        this.movableStrategy = movableStrategy;
        this.movementDistance = 0;
    }

    private Car(String name, MovableStrategy movableStrategy, int movementDistance) {
        validateCarName(name);
        this.name = name;
        this.movableStrategy = movableStrategy;
        this.movementDistance = movementDistance;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public int getMovementDistance() {
        return movementDistance;
    }

    public boolean hasMovementDistanceOf(int movementDistance) {
        return this.movementDistance == movementDistance;
    }

    public Car move() {
        int currentMovementDistance = movementDistance;
        if (movableStrategy.isMovable()) {
            currentMovementDistance++;
        }
        return new Car(name, movableStrategy, currentMovementDistance);
    }
}
