package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
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

        // 게임을 실행한다.

        // 게임이 끝날 때까지 반복한다.
    }

}
