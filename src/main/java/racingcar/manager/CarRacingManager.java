package racingcar.manager;

import racingcar.domain.CarRacing;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.domain.Turn;
import racingcar.io.CarRacingInputView;
import racingcar.io.CarRacingOutputView;

public class CarRacingManager {
    // 주요 의존성 관리
    private final CarRacingOutputView outputView = new CarRacingOutputView();
    private final CarRacingInputView inputView = new CarRacingInputView(outputView);

    public void execute() {
        CarRacing carRacing = createCarRacing();
        carRacing.start();
    }

    private CarRacing createCarRacing() {
        Cars cars = readCarsInfo(inputView);
        Turn turn = readTurn(inputView);
        Referee referee = new Referee();

        return new CarRacing(cars, turn, referee, outputView);
    }

    private Turn readTurn(CarRacingInputView inputView) {
        return Turn.fromTryCount(inputView.readTryToMoveTurnCount());
    }

    private Cars readCarsInfo(CarRacingInputView inputView) {
        return Cars.fromCarNames(inputView.readCarNames());
    }
}
