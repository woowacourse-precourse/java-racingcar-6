package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class RacingCars {
    public ArrayList<Car> cars = new ArrayList<>();

    public RacingCars(ArrayList<String> cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }
}
