package racingcar.domain;

public class Car {

    private static final int MOVABLE_OFFSET = 4;

    private final CarName name;
    private final CarPosition position;

    private Car(final CarName name, final CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(final String name, final int positionValue) {
        return new Car(CarName.from(name), new CarPosition(positionValue));
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void moveForward(final int randomNumber) {
        if (randomNumber >= MOVABLE_OFFSET) {
            position.increase(1);
        }
    }

    public boolean isWinner(final int winnerPosition) {
        return position.isSame(winnerPosition);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
