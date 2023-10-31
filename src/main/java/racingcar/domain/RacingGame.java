package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private List<RacingCar> cars = new ArrayList<>();
    private int tryCount;

    public RacingGame(List<RacingCar> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public boolean isFinish() {
        return tryCount == 0;
    }

    public void moveAllCars() {
        for (RacingCar car : cars) {
            car.moveForward(pickRandom());
        }
        tryCount -= 1;
    }

    private int pickRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<RacingCar> getWinners() {
        int maxPosition = getMaxPosition();
        return selectWinners(maxPosition);
    }

    private Integer getMaxPosition() {
        return Collections.max(cars.stream().map(RacingCar::getPosition).toList());
    }

    private List<RacingCar> selectWinners(int maxPosition) {
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}
