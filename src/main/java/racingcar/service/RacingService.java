package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.model.InputCarNameSplitter;
import racingcar.validator.ValidatorFactory;

public class RacingService {
    public List<String> carValidate(String carNamesInput) {
        InputCarNameSplitter splitter = new InputCarNameSplitter();
        String validatedCarNameInput = ValidatorFactory.forInputCarName().validate(carNamesInput);
        List<String> carNames = splitter.splitInputCarNames(validatedCarNameInput);

        return ValidatorFactory.forIndividualCarName().validate(carNames);
    }

    public void moveAllCar(int attemptCount, LinkedHashSet<Car> cars, Runnable afterEachRound) {
        for (int i = 0; i < attemptCount; i++) {
            moveCar(cars);
            afterEachRound.run();
        }
    }

    private void moveCar (LinkedHashSet <Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> generateRaceResult(LinkedHashSet<CarDto> carDtos) {
        RaceResultGenerator raceResultGenerator = new RaceResultGenerator();
        return raceResultGenerator.checkWinner(carDtos);
    }
}

