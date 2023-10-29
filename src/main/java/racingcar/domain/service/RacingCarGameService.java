package racingcar.domain.service;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.RacingCarGame;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.exception.validtaion.RacingCarGameValidationHandler;
import racingcar.input.RacingCarGameInput;

public class RacingCarGameService {

    private final RacingCarGameRepository racingCarGameRepository;

    public RacingCarGameService(RacingCarGameRepository racingCarGameRepository) {
        this.racingCarGameRepository = racingCarGameRepository;
    }

    public void registerCarAndGameCounter(RacingCarGameInput input) {
        validationGameCount(input.getGameCount());
        validationCars(input.getCars());

        RacingCarGame racingCarGame = RacingCarGame.createWithoutWinnerNames(input);

        racingCarGameRepository.save(racingCarGame);
    }

    private void validationGameCount(String gameCount) {
        RacingCarGameValidationHandler.validationHasText(gameCount);
        RacingCarGameValidationHandler.validationNumeric(gameCount);
        RacingCarGameValidationHandler.validationUnderOrEqual100(gameCount);
    }

    private void validationCars(List<Car> cars) {
        RacingCarGameValidationHandler.validationCarsEmpty(cars);
    }
}
