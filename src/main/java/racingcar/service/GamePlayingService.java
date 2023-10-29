package racingcar.service;

import racingcar.dto.AttemptCount;
import racingcar.dto.CarsState;
import racingcar.dto.WinnersDto;
import racingcar.model.Cars;
import racingcar.validator.AttemptCountValidator;
import racingcar.vo.Winners;

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

    public WinnersDto getWinners(Cars cars) {
        return toWinnersDto(cars.findWinners());
    }

    private WinnersDto toWinnersDto(Winners result) {
        return result.toDto();
    }
}
