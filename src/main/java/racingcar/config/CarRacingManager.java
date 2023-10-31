package racingcar.config;

import racingcar.domain.CarRacing;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.domain.Turn;
import racingcar.io.CarRacingInputProcessor;
import racingcar.io.CarRacingOutputProcessor;

public class CarRacingManager {

    public void execute() {
        CarRacingOutputProcessor outputProcessor = new CarRacingOutputProcessor();
        CarRacingInputProcessor inputProcessor = new CarRacingInputProcessor(outputProcessor);

        CarRacing carRacing = createCarRacing(inputProcessor, outputProcessor);
        carRacing.start();
    }

    private static CarRacing createCarRacing(CarRacingInputProcessor inputProcessor,
                                             CarRacingOutputProcessor outputProcessor) {
        Cars cars = readCarsInfo(inputProcessor);
        Turn turn = readTurn(inputProcessor);
        Referee referee = new Referee();

        return new CarRacing(cars, turn, referee, outputProcessor);
    }

    private static Turn readTurn(CarRacingInputProcessor inputProcessor) {
        return Turn.fromTryCount(inputProcessor.readTryToMoveTurnCount());
    }

    private static Cars readCarsInfo(CarRacingInputProcessor inputProcessor) {
        return Cars.fromCarNames(inputProcessor.readCarNames());
    }
}
