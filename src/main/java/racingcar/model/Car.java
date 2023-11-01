package racingcar.model;

public class Car {

    private final Name name;
    private final CurrentLocation currentLocation;

    private Car(Name name, CurrentLocation currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public static Car createCar(String inputName) {
        Name name = Name.createName(inputName);
        CurrentLocation currentLocation = CurrentLocation.createCurrentLocation();
        return new Car(name, currentLocation);
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        currentLocation.moveLocation();
    }

    public int getCurrentLocation() {
        return currentLocation.getCurrent();
    }
}
