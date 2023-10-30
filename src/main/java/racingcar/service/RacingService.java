package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.model.InputCarNameSplitter;
import racingcar.validator.AttemptCountValidator;
import racingcar.validator.IndividualCarNameValidator;
import racingcar.validator.InputCarNameValidator;

public class RacingService {

    // TODO : DI 필요
    public List<String> carValidate(String carNamesInput) {
        InputCarNameValidator inputCarNameValidator = new InputCarNameValidator();
        InputCarNameSplitter splitter = new InputCarNameSplitter();
        IndividualCarNameValidator individualCarNameValidator = new IndividualCarNameValidator();

        String validatedCarNameInput = inputCarNameValidator.validate(carNamesInput);
        List<String> carNames = splitter.splitInputCarNames(validatedCarNameInput);
        return individualCarNameValidator.validate(carNames);
    }
    public int attemptCountValidate(int countInput) {
        AttemptCountValidator countValidator = new AttemptCountValidator();
        return countValidator.validate(countInput);
    }

    public LinkedHashSet<Car> createCars(List<String> validatedCarNames) {
        RaceCarEnroller enroller = new RaceCarEnroller();
        return enroller.enrollCars(validatedCarNames);
    }

    public void moveAllCar(int attemptCount, LinkedHashSet<Car> cars) {
        for (int i = 0; i < attemptCount; i++) {
            moveCar(cars);
            System.out.println();
        }
    }

    private void moveCar (LinkedHashSet <Car> cars) {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    public List<String> generateRaceResult(LinkedHashSet<Car> cars) {
        RaceResultGenerator raceResultGenerator = new RaceResultGenerator();
        return raceResultGenerator.checkWinner(cars);
    }
}

