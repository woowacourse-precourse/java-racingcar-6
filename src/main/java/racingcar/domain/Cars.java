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

    public void moveAllCars(final Movable movable) {
        for (Car car : carList) {
            if (movable.canMove()) {
                car.move();
            }
        }
    }

    public List<Car> findWinner() {
        List<Car> winnerList = new ArrayList<>();

        getMaxPosition(winnerList);

        return winnerList;
    }

    private void getMaxPosition(final List<Car> winnerList) {
        int maxPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car);
            }
        }
    }

    public CarsDto toCarsDto() {
        List<CarDto> carDtos = carList.stream()
                .map(Car::toCarDto)
                .toList();

        return new CarsDto(carDtos);
    }
}
