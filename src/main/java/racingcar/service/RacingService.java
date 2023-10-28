package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.List;

public class RacingService {
    private final OutputView outputView = new OutputView();
    private final List<Car> cars;
    private final int times;

    public RacingService(List<Car> cars, int times) {
        this.cars = cars;
        this.times = times;
    }

    public void gameProgress() {
        outputView.gameStart();
        for (int i = 0; i < times; i++) {
            progressOnceTime();
        }
    }

    private void progressOnceTime() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.moveForward(randomValue);
            outputView.gameProgress(car);
        }
        outputView.skipLine();
    }
}
