package racingcar.Service;

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
    private void randomDriveForward(Game game) {
        for (Car car : game.getCarList()) {
            if (RandomNumberGenerator.DRIVEABLE_VALUE <= randomNumberGenerator.getRandomNumber()) {
                car.driveForward(1);
            }
        }
    }
}
