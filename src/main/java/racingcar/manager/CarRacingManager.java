package racingcar.manager;

import racingcar.domain.CarRacing;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.domain.Turn;
import racingcar.io.CarRacingInputProcessor;
import racingcar.io.CarRacingOutputProcessor;

public class CarRacingManager {
    // 주요 의존성 관리
    private final CarRacingOutputProcessor outputProcessor = new CarRacingOutputProcessor();
    private final CarRacingInputProcessor inputProcessor = new CarRacingInputProcessor(outputProcessor);

    public void execute() {
        CarRacing carRacing = createCarRacing();
        carRacing.start();
    }

    private CarRacing createCarRacing() {
        Cars cars = readCarsInfo(inputProcessor);
        Turn turn = readTurn(inputProcessor);
        Referee referee = new Referee();

        return new CarRacing(cars, turn, referee, outputProcessor);
    }

    private Turn readTurn(CarRacingInputProcessor inputProcessor) {
        return Turn.fromTryCount(inputProcessor.readTryToMoveTurnCount());
    }

    private Cars readCarsInfo(CarRacingInputProcessor inputProcessor) {
        return Cars.fromCarNames(inputProcessor.readCarNames());
    }
}
