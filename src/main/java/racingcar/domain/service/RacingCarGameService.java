package racingcar.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.RacingCarGame;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.domain.service.input.RegisterRacingCarGameInput;
import racingcar.exception.RacingCarGameException;
import racingcar.exception.RacingCarGameRepositoryException;
import racingcar.exception.validtaion.RacingCarGameValidationHandler;

public class RacingCarGameService {

    private final RacingCarGameRepository racingCarGameRepository;
    private static final int GAME_END_CONDITION_NUMBER = 0;
    private static final int MIN_DISTANCE = 0;

    public RacingCarGameService(RacingCarGameRepository racingCarGameRepository) {
        this.racingCarGameRepository = racingCarGameRepository;
    }

    public void registerCarsAndGameCounter(RegisterRacingCarGameInput input) {
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

    public RacingCarGame computeCarsDistanceAndGameCount(Long racingCarGameId, List<Car> cars) {
        RacingCarGame findRacingCarGame = racingCarGameRepository.findById(racingCarGameId)
                .orElseThrow(() -> new RacingCarGameRepositoryException(RacingCarGameRepositoryException.NOT_FOUND));

        findRacingCarGame.changeCars(cars);
        findRacingCarGame.changeGameCount(findRacingCarGame.getGameCount() - 1L);
        racingCarGameRepository.update(findRacingCarGame.getId(), findRacingCarGame);

        return findRacingCarGame;
    }

    public List<String> computeGameWinners(Long racingCarGameId) {
        RacingCarGame findRacingCarGame = racingCarGameRepository.findById(racingCarGameId)
                .orElseThrow(() -> new RacingCarGameRepositoryException(RacingCarGameRepositoryException.NOT_FOUND));

        if (findRacingCarGame.getGameCount() != GAME_END_CONDITION_NUMBER) {
            throw new RacingCarGameException(RacingCarGameException.NOT_GAME_END_CONDITION_RESTRICTION);
        }

        int carsMaxDistance = getCarsMaxDistance(findRacingCarGame);
        List<String> winnerNames = getWinnerNames(findRacingCarGame, carsMaxDistance);

        findRacingCarGame.changeWinnerNames(winnerNames);
        racingCarGameRepository.update(racingCarGameId, findRacingCarGame);

        return winnerNames;
    }

    private List<String> getWinnerNames(RacingCarGame racingCarGame, int carsMaxDistance) {
        return racingCarGame.getCars().stream()
                .filter(car -> car.getDistance() == carsMaxDistance)
                .map(Car::getCarName)
                .sorted()
                .collect(Collectors.toList());
    }

    private int getCarsMaxDistance(RacingCarGame racingCarGame) {
        return racingCarGame.getCars().stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(MIN_DISTANCE);
    }
}
