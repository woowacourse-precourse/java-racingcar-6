package racingcar.car;

public record Car(CarName carName, CarLocation carLocation) {
    private static final int START_LOCATION = 0;

    public Car(String name) {
        this(new CarName(name), new CarLocation(START_LOCATION));
    }

    public Car(String name, int location) {
        this(new CarName(name), new CarLocation(location));
    }

    public void moveForward(int randomNumber) {
        carLocation.increaseLocation(randomNumber);
    }

    public String getCarName() {
        return carName.name();
    }

    public int getCarLocation() {
        return carLocation.getLocation();
    }
}
