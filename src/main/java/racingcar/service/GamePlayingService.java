package racingcar.service;

import racingcar.dto.AttemptCount;
import racingcar.dto.CarsState;
import racingcar.model.Cars;
import racingcar.validator.AttemptCountValidator;
import racingcar.vo.ResultMessage;

public class GamePlayingService {
    public GamePlayingService() {

    }

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

    public ResultMessage getResultMessage(Cars cars) {
        return cars.findWinners();
    }
}
