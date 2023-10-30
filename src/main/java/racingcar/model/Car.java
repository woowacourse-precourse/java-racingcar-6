package racingcar.model;

public class Car {

    private final String name;
    private final CurrentLocation currentLocation;

    private Car(String name, CurrentLocation currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public static Car createCar(String name) {
        CurrentLocation currentLocation = CurrentLocation.createCurrentLocation();
        return new Car(name, currentLocation);
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation(){
        return currentLocation.getCurrent();
    }
}
