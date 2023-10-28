package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class GameStatus {
    private final Cars cars;
    private final int playCount;
    private int currentPlayCount;

    public GameStatus(Cars cars, int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    private void nextStatus() {
        this.currentPlayCount += 1;
    }

    public boolean isEnd() {
        return this.currentPlayCount == this.playCount;
    }

    private void carsMoveForward() {
        for (Car car : this.cars.getCars()) {
            if (4 <= Randoms.pickNumberInRange(0, 9)) {
                car.moveForward();
            }
        }
    }
}
