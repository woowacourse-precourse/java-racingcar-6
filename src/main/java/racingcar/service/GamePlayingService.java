package racingcar.service;

import java.util.List;
import racingcar.Constants;
import racingcar.dto.AttemptCount;
import racingcar.dto.CarsDto;
import racingcar.dto.CarsState;
import racingcar.dto.WinnersResult;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validator.AttemptCountValidator;

public class GamePlayingService {
    public Cars generateCars(String inputCars) {
        return new Cars(inputCars);
    }

    public AttemptCount createAttemptCount(String input) {
        AttemptCountValidator validator = AttemptCountValidator.INSTANCE;
        return validator.validate(input);
    }

    public CarsState tryForward(Cars cars) {
        cars.attemptForward();
        return getCarsState(cars);
    }

    private CarsState getCarsState(Cars cars) {
        return cars.getCurrentCarsResult();
    }

    public WinnersResult getWinners(Cars cars) {
        CarsDto winners = cars.findWinners();
        return toWinners(winners.cars());
    }

    private WinnersResult toWinners(List<Car> winners) {
        StringBuilder result = new StringBuilder();

        winners.stream().map(Car::getNameValue)
                .forEach((name) -> addResult(result, name));

        trim(result);
        return new WinnersResult(result.toString());
    }

    private void addResult(StringBuilder result, String name) {
        result.append(Constants.WHITESPACE);
        result.append(name);
        result.append(Constants.COMMA);
    }

    private void trim(StringBuilder result) {
        result.deleteCharAt(Constants.RESULT_FIRST_INDEX);
        result.deleteCharAt(getLastIndexOfResult(result));
    }

    private int getLastIndexOfResult(StringBuilder result) {
        return result.length() - 1;
    }
}
