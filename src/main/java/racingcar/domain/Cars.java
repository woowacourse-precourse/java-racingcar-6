package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<String> carNames) {
        carList = carNames.stream()
                .map(Car::of)
                .toList();
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

    public CarsDto toCarsDto() {
        List<CarDto> carDtos = carList.stream()
                .map(Car::toCarDto)
                .toList();

        return new CarsDto(carDtos);
    }
}
