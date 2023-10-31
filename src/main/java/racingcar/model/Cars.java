package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(){
        cars = new ArrayList<>();
    }

    public void setNames(String alignedCarNames) {
        String[] carNames = alignedCarNames.split(",");

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

    }
}
