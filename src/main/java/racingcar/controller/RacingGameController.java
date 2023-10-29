package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.judge.WinnerJudge;
import racingcar.domain.numberpicker.RandomNumberPicker;
import racingcar.io.UserIoManager;

public class RacingGameController {

    private final RandomNumberPicker randomNumberPicker;
    private final UserIoManager ioManager;

    public RacingGameController(RandomNumberPicker randomNumberPicker, UserIoManager ioManager) {
        this.randomNumberPicker = randomNumberPicker;
        this.ioManager = ioManager;
    }

    public void run() {
        List<CarName> carNames = CarName.from(ioManager.readCarNames());
        List<Car> cars = Car.namesOf(carNames);

        long movingCount = ioManager.readMovingCount();

        RacingGame racingGame = RacingGame.newGame(new Cars(cars), movingCount);

        while (racingGame.isInProgress()) {
            racingGame.moveOnce(this.randomNumberPicker);
            ioManager.notifyMoveResult(racingGame.getCars());
        }

        WinnerJudge judge = new WinnerJudge(racingGame.getCars());
        ioManager.notifyWinner(judge.judge());
    }

}
