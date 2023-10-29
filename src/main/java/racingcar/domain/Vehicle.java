package racingcar.domain;

public abstract class Vehicle implements Comparable<Vehicle> {

    String name;
    Distance distance;

    public abstract void drive();

    @Override
    public int compareTo(Vehicle otherVehicle) {
        System.out.println(this.distance.compareTo(otherVehicle.distance));
        return this.distance.compareTo(otherVehicle.distance);
    }
}
