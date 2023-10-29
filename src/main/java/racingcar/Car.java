package racingcar;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public static CarRacingResult convertToCarRacingResult(Car car) {
        return new CarRacingResult(car.name, car.location);
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
}
