package racingcar;

import java.util.List;

public class CarFactory {

    private final RacingCarMovingStrategy racingCarMovingStrategy;

    private CarFactory(RacingCarMovingStrategy racingCarMovingStrategy) {
        this.racingCarMovingStrategy = racingCarMovingStrategy;
    }

    public static CarFactory createCarFactoryWithMovingStrategy(
        RacingCarMovingStrategy racingCarMovingStrategy) {
        return new CarFactory(racingCarMovingStrategy);
    }

    public RacingCars createRacingCarsByNames(List<String> carNames) {
        List<RacingCar> racingCars = carNames.stream()
            .map(name -> new RacingCar(name, racingCarMovingStrategy))
            .toList();
        return new RacingCars(racingCars);
    }
}
