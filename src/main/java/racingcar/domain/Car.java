package racingcar.domain;


import static racingcar.util.MagicNumber.MOVING_FORWARD;

public class Car implements Comparable<Car> {

    private final Name name;
    private final Distance distance;

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD.getNumber()) {
            distance.moveDistance();
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getDistance() {
        return distance.getValue();
    }

    public boolean isSameDistance(Car compareCar) {
        return this.distance.getValue() == compareCar.distance.getValue();
    }

    @Override
    public int compareTo(Car compareCar) {
        return this.distance.getValue() - compareCar.distance.getValue();
    }
}
