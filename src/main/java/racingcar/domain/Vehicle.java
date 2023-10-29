package racingcar.domain;

public abstract class Vehicle implements Comparable<Vehicle> {

    String name;
    Distance distance;

    public abstract void advance();

    @Override
    public int compareTo(Vehicle otherVehicle) {
        return this.distance.compareTo(otherVehicle.distance);
    }
}
