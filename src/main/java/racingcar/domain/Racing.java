package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Racing {
    private final Cars cars;
    private final long attempCount;

    public Racing(Cars cars, long attemptCount) {
        this.cars = cars;
        this.attempCount = attemptCount;
    }

    public void race() {
        HashMap<String, Integer> carPositions = cars.getCars();
        carPositions.forEach(this::moveCarIfMovable);
    }

    private void moveCarIfMovable(String car, Integer position) {
        int randomValue = pickRandomNumber();
        if (isMovable(randomValue)) {
            cars.moveCar(car);
        }
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isMovable(int randomValue) {
        return randomValue > 3;
    }

    public long getAttempCount() {
        return attempCount;
    }
}


