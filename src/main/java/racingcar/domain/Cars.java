package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCarsFromNames(String[] names) {
        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
    }

    public List<Car> getCars() {
        return cars;
    }
}