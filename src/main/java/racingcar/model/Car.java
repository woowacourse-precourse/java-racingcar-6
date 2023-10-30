package racingcar.model;

import java.util.List;

public class Car {

    private final String name;
    private final CurrentLocation currentLocation;

    private Car(String name, CurrentLocation currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public static Car createCar(String name) {
        valid(name);
        CurrentLocation currentLocation = CurrentLocation.createCurrentLocation();
        return new Car(name, currentLocation);
    }

    private static void valid(String userInputList) {
        validLength(userInputList);
        validBlankString(userInputList);
    }

    private static void validLength(String userInputList) {
        if (userInputList.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validBlankString(String userInputList) {
        if (userInputList.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation(){
        return currentLocation.getCurrent();
    }
}
