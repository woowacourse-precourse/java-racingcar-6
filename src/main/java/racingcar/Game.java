package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.Util;
import racingcar.utils.Validator;

public class Game {
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
        Validator.validateDuplicateCarName(carNames);
        List<Car> carsWithName = createCarsWithName(carNames);
        return new Cars(carsWithName);
    }

    private List<Car> createCarsWithName(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}