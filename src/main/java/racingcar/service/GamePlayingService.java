package racingcar.service;

import java.util.List;
import racingcar.dto.AttemptCount;
import racingcar.dto.CarsState;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarsGenerator;
import racingcar.model.Winners;
import racingcar.validator.AttemptCountValidator;

public class GamePlayingService {
    private Cars cars;


    public Cars generateCars(String inputNames) {
        CarsGenerator carsGenerator = new CarsGenerator();
        return carsGenerator.generate(inputNames);
    }

    public AttemptCount createAttemptCount(String input) {
        AttemptCountValidator.INSTANCE.validate(input);

        return new AttemptCount(toInt(input));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public void tryForward(Cars cars) {
        cars.attemptForward();
    }

    public CarsState getCarsState(Cars cars) {
        return cars.getCarsState();
    }

    public Winners getWinners(Cars cars) {
        return createWinners(cars.findWinningCars());
    }

    private Winners createWinners(List<Car> winnersCar) {
        return new Winners(winnersCar);
    }
}
