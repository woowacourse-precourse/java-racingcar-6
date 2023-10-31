package racingcar.model;

import java.util.List;
import racingcar.dto.MoveResultDto;

public class Cars {

    private final List<Car> cars;

    private Cars(CarNames carNames) {
        cars = carNames.getCarNames().stream()
                .map(Car::createWithName)
                .toList();
    }

    public static Cars createWithNames(CarNames carNames) {
        return new Cars(carNames);
    }

    public List<MoveResultDto> getMoveResultDTOs() {
        return cars.stream().map(Car::getResultDto).toList();
    }

    public List<String> getWinner() {
        return cars.stream()
                .filter((car) -> isWinner(car, measureFarthestLocation(cars)))
                .map(Car::getName)
                .toList();
    }

    private static int measureFarthestLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static boolean isWinner(Car car, int farthestLocation) {
        if (car.getLocation() == farthestLocation) {
            return true;
        }
        return false;
    }

    public List<Car> getCars() {
        return cars;
    }
}
