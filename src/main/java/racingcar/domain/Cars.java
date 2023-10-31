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

    public WinnerDto findWinner() {

        return getWinnerFromMaxPosition();
    }

    private WinnerDto getWinnerFromMaxPosition() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return new WinnerDto(winners);
    }

    public CarsDto toCarsDto() {
        List<CarDto> carDtos = carList.stream()
                .map(Car::toCarDto)
                .toList();

        return new CarsDto(carDtos);
    }
}
