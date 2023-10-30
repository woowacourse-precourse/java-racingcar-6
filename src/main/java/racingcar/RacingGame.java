package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    List<Car> racingCars = new ArrayList<Car>();

    RacingGame(String cars) {
        String[] names = cars.split(",");
        for(String name : names) {
            racingCars.add(new Car(name));
        }
    }

    void printStep() {
        for(Car car : racingCars) {
            System.out.println(car);
        }
    }
}
