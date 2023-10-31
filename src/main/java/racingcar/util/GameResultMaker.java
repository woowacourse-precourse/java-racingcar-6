package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class GameResultMaker {

    public void makeGameResult(List<Car> carNames) {
        for (Car car : carNames) {
            if (CarMotionMaker.isCarMoved()) {
                car.increaseMovingCount();
            }
        }
    }
}
