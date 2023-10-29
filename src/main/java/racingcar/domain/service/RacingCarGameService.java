package racingcar.domain.service;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.RacingCarGame;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.exception.RacingCarGameRepositoryException;
import racingcar.exception.validtaion.RacingCarGameValidationHandler;
import racingcar.input.RegisterRacingCarGameInput;

public class RacingCarGameService {

    private final RacingCarGameRepository racingCarGameRepository;

    public RacingCarGameService(RacingCarGameRepository racingCarGameRepository) {
        this.racingCarGameRepository = racingCarGameRepository;
    }

    public void registerCarAndGameCounter(RegisterRacingCarGameInput input) {
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

    public RacingCarGame computeCarsDistanceAndGameCount(Long id, List<Car> cars) {
        RacingCarGame findRacingCarGame = racingCarGameRepository.findById(id)
                .orElseThrow(() -> new RacingCarGameRepositoryException(RacingCarGameRepositoryException.NOT_FOUND));

        findRacingCarGame.changeCars(cars);
        findRacingCarGame.changeGameCount(findRacingCarGame.getGameCount() - 1L);
        racingCarGameRepository.update(findRacingCarGame.getId(), findRacingCarGame);

        return findRacingCarGame;
    }
}
