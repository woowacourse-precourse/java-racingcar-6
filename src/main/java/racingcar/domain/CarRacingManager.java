package racingcar.domain;

import racingcar.io.CarRacingInputManager;
import racingcar.io.CarRacingOutputManager;

public class CarRacingManager {

    public void execute() {
        CarRacingOutputManager outputManager = new CarRacingOutputManager();
        CarRacingInputManager inputManager = new CarRacingInputManager(outputManager);

        CarRacing carRacing = createCarRacing(inputManager, outputManager);
        carRacing.start();
    }

    private static CarRacing createCarRacing(CarRacingInputManager inputManager,
                                             CarRacingOutputManager outputManager) {
        Cars cars = readCarsInfo(inputManager);
        Turn turn = readTurn(inputManager);
        Referee referee = new Referee();

        return new CarRacing(cars, turn, referee, outputManager);
    }

    private static Turn readTurn(CarRacingInputManager inputManager) {
        return Turn.fromTryCount(inputManager.readTryToMoveTurnCount());
    }

    private static Cars readCarsInfo(CarRacingInputManager inputManager) {
        return Cars.fromCarNames(inputManager.readCarNames());
    }
}
