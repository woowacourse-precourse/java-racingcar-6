package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.model.InputCarNameSplitter;
import racingcar.validator.Validator;

public class RacingService {
    public List<String> carValidate(String carNamesInput) {
        InputCarNameSplitter splitter = new InputCarNameSplitter();
        String validatedCarNameInput = Validator.forInputCarName().validate(carNamesInput);
        List<String> carNames = splitter.splitInputCarNames(validatedCarNameInput);

        return Validator.forIndividualCarName().validate(carNames);
    }
    public int attemptCountValidate(int countInput) {
        return Validator.forAttemptCount().validate(countInput);
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

