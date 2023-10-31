package racingcar.game.components;

import racingcar.game.components.Car;

import java.util.List;

/**
 * 게임 실행을 위해 필요한 값
 */
public class GameSetting {
    private List<Car> carList;
    private int attemptCount;

    public GameSetting(List<Car> carList, int attemptCount) {
        this.carList = carList;
        this.attemptCount = attemptCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
