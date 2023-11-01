package racingcar.model;

import java.util.List;
import racingcar.dto.RaceResultDTO;

public class Cars {

    private final List<Car> cars;

    public Cars(CarNames carNames) {
        cars = carNames.getCarNames().stream()
                .map(Car::createWithName)
                .toList();
    }

    public static Cars createWithNames(CarNames carNames) {
        return new Cars(carNames);
    }

    public List<RaceResultDTO> move() {
        return cars.stream().map(Car::move)
                .toList();
    }

    public List<String> getWinner() {
        return cars.stream()
                .filter((car) -> isWinner(car, getFarthestLocation()))
                .map(Car::getName)
                .toList();
    }

    private int getFarthestLocation() {
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

    //test만을 위한 코드
    protected Car getCarForTest(int i) {
        return cars.get(i);
    }
}
