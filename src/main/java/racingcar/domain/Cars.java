package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

    public List<String> findWinner() {
        List<String> winnerList = new ArrayList<>();

        Integer maxPosition = Collections.max(carList.values());

        for (Entry<Car, Integer> entry : carList.entrySet()) {
            if (entry.getValue().equals(maxPosition)) {
                winnerList.add(entry.getKey().getName());
            }
        }

        return winnerList;
    }

    private Map<Car, Integer> moveResults() {
        carList.replaceAll((car, v) -> car.getPosition());

        return carList;
    }
}
