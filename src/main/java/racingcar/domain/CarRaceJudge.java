package racingcar.domain;

import java.util.List;

public class CarRaceJudge {

    public static final int START_POSITION = 0;

    private final CarRepository carRepository = CarRepository.getInstance();

    public void addCars(final List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> Car.of(name, START_POSITION))
                .toList();

        carRepository.saveAll(cars);
    }
}
