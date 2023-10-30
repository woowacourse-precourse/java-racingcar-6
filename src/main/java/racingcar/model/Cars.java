package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public void initCars(List<String> carNames) {
        carNames.stream()
                .map(name -> new Car(new Name(name), new Position()))
                .forEach(carList::add);
    }

}
