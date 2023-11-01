package racingcar;

import java.util.ArrayList;

public class RacingGameUtils {

    int renewMaxLocation(int currentLocation, int maxLocation) {
        return Math.max(currentLocation, maxLocation);
    }

    ArrayList<String> makeCarsName (String carName) {
        ArrayList<String> carsName = new ArrayList<>();
        carsName.add(carName);
        return carsName;
    }

    void moveCar(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveForward();
        }
    }
}
