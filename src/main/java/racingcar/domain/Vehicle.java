package racingcar.domain;

public abstract class Vehicle implements Comparable<Vehicle> {

    protected String name;
    protected Distance distance;

    public abstract void printName();
    public abstract void advance();

    @Override
    public int compareTo(Vehicle otherVehicle) {
        return this.distance.compareTo(otherVehicle.distance);
    }
}
