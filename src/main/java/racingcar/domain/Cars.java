package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<String> carNames) {
        carList = carNames.stream()
                .map(Car::of)
                .toList();
    }

    public void moveAllCars(Movable movable) {
        for (Car car : carList) {
            if (movable.canMove()) {
                car.move();
            }
        }
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
