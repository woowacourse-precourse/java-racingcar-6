package racingcar.model;

import racingcar.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        List<String> carListNames = Utils.toList(carNames);
        carListNames.stream().forEach(name -> cars.add(new Car(name)));
    }

}
