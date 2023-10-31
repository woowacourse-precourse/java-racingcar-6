package racingcar;

import racingcar.domain.CarRacing;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarInputManager;
import racingcar.domain.RacingCarOutputManager;
import racingcar.domain.Referee;
import racingcar.domain.Turn;

public class Application {
    public static void main(String[] args) {
        RacingCarOutputManager outputManager = new RacingCarOutputManager();
        RacingCarInputManager inputManager = new RacingCarInputManager(outputManager);

        CarRacing carRacing = initializeCarRacing(inputManager, outputManager);
        carRacing.start();
    }


    private static CarRacing initializeCarRacing(RacingCarInputManager inputManager,
                                                 RacingCarOutputManager outputManager) {
        Cars cars = readCarsInfo(inputManager);
        Turn turn = readTurn(inputManager);
        Referee referee = new Referee();

        return new CarRacing(cars, turn, referee, outputManager);
    }

    private static Turn readTurn(RacingCarInputManager inputManager) {
        return Turn.fromTryCount(inputManager.readTryToMoveTurnCount());
    }

    private static Cars readCarsInfo(RacingCarInputManager inputManager) {
        return Cars.fromCarNames(inputManager.readCarNames());
    }
}
