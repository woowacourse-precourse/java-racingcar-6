package racingcar.domain;

public class Car {

    private static final int MOVABLE_OFFSET = 4;

    private final CarName name;
    private int position;

    private Car(final CarName name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(final String name, final int position) {
        return new Car(CarName.from(name), position);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(final int randomNumber) {
        if (randomNumber >= MOVABLE_OFFSET) {
            position++;
        }
    }

    public boolean isWinner(final int winnerPosition) {
        return position == winnerPosition;
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
