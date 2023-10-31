package racingcar;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public static Car deepCopy(Car car) {
        Car newCar = new Car(car.name);
        newCar.location = car.location;
        return newCar;
    }

    public void moveForward() {
        location++;
    }

    @Override
    public String toString() {
        String currentLocation = "-".repeat(location);
        return name + " : " + currentLocation;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
