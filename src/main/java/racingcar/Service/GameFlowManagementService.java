package racingcar.Service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Game;
import racingcar.Repository.GameRepository;
import racingcar.Util.RandomNumberGenerator;

public class GameFlowManagementService {
    private final GameRepository gameRepository = new GameRepository();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private static final int SET_DEFAULT_INT = -1;

    public void playRacingCarGameRound(Game game) {
        randomDriveForward(game);
        game.incrementCurrentTryCount();
    }

    public List<String> getRoundWinnerCarNames(Game game) {
        List<Car> carList = game.getCarList();
        int maximumLocation = getMaximumLocation(carList);
        return getFurthestCarList(carList, maximumLocation);
    }

    public Boolean roundIsFinished(Game game) {
        return gameRepository.gameIsFinished(game);
    }

    public Long saveGamestatus(Game game) {
        return gameRepository.saveGameProcess(game);
    }

    private List<String> getFurthestCarList(List<Car> carList, int maximumLocation) {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLocation() == maximumLocation) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private int getMaximumLocation(List<Car> carList) {
        int largestLocation = SET_DEFAULT_INT;
        for (Car car : carList) {
            if (largestLocation < car.getLocation()) {
                largestLocation = car.getLocation();
            }
        }
        return largestLocation;
    }

    private void randomDriveForward(Game game) {
        for (Car car : game.getCarList()) {
            if (RandomNumberGenerator.DRIVEABLE_VALUE <= randomNumberGenerator.getRandomNumber()) {
                car.driveForward(1);
            }
        }
    }
}
