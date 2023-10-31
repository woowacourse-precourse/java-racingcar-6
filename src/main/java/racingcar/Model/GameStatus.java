package racingcar.Model;

import java.util.ArrayList;
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

    private int getMaxCarPosition() {
        int maxPosition = -1;
        for (int position : getCarpositions()) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }

    public List<String> getMaxCarNames() {
        int maxPosition = getMaxCarPosition();
        List<String> winner = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    public void nextStatus() {
        this.currentPlayCount += 1;
    }

    public boolean isEnd() {
        return this.currentPlayCount == this.playCount;
    }

    public void carsMoveForward() {
        for (Car car : this.cars.getCarList()) {
            if (4 <= getRandomNumber()) {
                car.moveForward();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
