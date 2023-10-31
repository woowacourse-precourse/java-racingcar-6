package racingcar.models;

public class CarStatus {
    private final String name;
    private final int moveDistance;

    public CarStatus(String name, int moveDistance) {
        this.name = name;
        this.moveDistance = moveDistance;
    }

    public static CarStatus of(Car car) {
        return new CarStatus(car.getName(), car.getMoveDistance());
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveDistance);
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
