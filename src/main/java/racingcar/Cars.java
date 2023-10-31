package racingcar;

import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(String name) {
        cars.add(new Car(name));
    }

    public void printRacingResult() {

    }
}
