package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
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
        // 차 이름을 입력받고, 차를 세팅한다.
        List<CarName> carNames = CarName.from(ioManager.readCarNames());
        List<Car> cars = Car.namesOf(carNames);

        // 이동 횟수를 입력받는다.
        long movingCount = ioManager.readMovingCount();

        // 게임을 만든다.
        RacingGame racingGame = RacingGame.newGame(new Cars(cars), movingCount);

        // 게임이 끝날 때까지 반복한다.
        // TODO '실행결과 텍스트' 출력

        while (racingGame.isInProgress()) {
            // 게임을 실행한다.
            racingGame.moveOnce(this.randomNumberPicker);

            // 이동 결과를 출력한다.
            ioManager.notifyMoveResult(racingGame.getCars());
        }

        // 게임이 종료되면 우승자를 판독하고, 우승자를 알려준다.

    }

}
