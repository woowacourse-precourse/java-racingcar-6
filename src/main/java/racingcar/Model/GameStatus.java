package racingcar.Model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameStatus {
    private final Cars cars;
    private final int playCount;
    private int currentPlayCount;

    public GameStatus(Cars cars, int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    public List<String> getCarNames() {
        return this.cars.getCarNames();
    }

    public List<Integer> getCarpositions() {
        return this.cars.getCarpositions();
    }

    public void nextStatus() {
        this.currentPlayCount += 1;
    }

    public boolean isEnd() {
        return this.currentPlayCount == this.playCount;
    }

    public void carsMoveForward() {
        for (Car car : this.cars.getCars()) {
            if (4 <= returnRandomNumber()) {
                car.moveForward();
            }
        }
    }

    private int returnRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
