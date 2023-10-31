package racingcar.domain;


import static racingcar.util.MagicNumber.MOVING_FORWARD;

public class Car implements Comparable<Car> {

    private final Name name;
    private int distance;

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = distance;
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD.getNumber()) {
            distance++;
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getDistance() {
        return distance;
    }

    public boolean isSameDistance(Car compareCar) {
        return this.distance == compareCar.distance;
    }

    @Override
    public int compareTo(Car compareCar) {
        return this.distance - compareCar.distance;
    }
}
