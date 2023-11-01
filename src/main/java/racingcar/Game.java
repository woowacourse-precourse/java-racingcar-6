package racingcar;

import java.util.HashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.Util;

public class Game {
    private static final String DUPLICATE_NAME = "자동차의 이름은 중복될 수 없습니다.";
    private final Cars cars;
    public Game(List<String> carNames) {
        this.cars = initCars(carNames);
    }

    public RoundResult race() {
        cars.race();
        return new RoundResult(cars.getCarDtos());
    }

    public List<CarDto> getWinners() {
        List<Car> winners = cars.findWinners();
        return Util.carsToCarDtos(winners);
    }

    private Cars initCars(List<String> carNames) {
        validateDuplicateCarName(carNames);
        List<Car> carsWithName = createCarsWithName(carNames);
        return new Cars(carsWithName);
    }

    private List<Car> createCarsWithName(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateDuplicateCarName(List<String> carNames) {
        HashSet<String> carNameSet = new HashSet<>(carNames);

        if (isDuplicateNameExist(carNames, carNameSet)) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    private boolean isDuplicateNameExist(List<String> carNames, HashSet<String> carNameSet) {
        return carNameSet.size() != carNames.size();
    }
}