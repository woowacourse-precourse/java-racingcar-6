package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final Map<Car, Integer> carList = new HashMap<>();

    public Cars(final List<String> carNames) {
        int initialPosition = 0;

        for (String carName : carNames) {
            carList.put(Car.of(carName), initialPosition);
        }
    }

    public Map<Car, Integer> moveAllCars() {
        for (Car car : carList.keySet()) {
            car.move();
        }

        return moveResults();
    }

    private Map<Car, Integer> moveResults() {
        carList.replaceAll((car, v) -> car.getPosition());

        return carList;
    }
}
