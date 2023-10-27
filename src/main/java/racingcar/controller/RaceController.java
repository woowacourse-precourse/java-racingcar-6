package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RaceController {
    private static final int RANGE_START_NUMBER = 0;
    private static final int RANGE_END_NUMBER = 9;
    private static final int MOVE_CRITERIA = 4;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
    }

    public boolean isMoved() {
        if (getRandomNumber() >= MOVE_CRITERIA) {
            return true;
        }
        return false;
    }

    public void addRecord(Car car) {
        if (isMoved()) {
            car.addRecord();
        }
    }

    public String getNameAndRecord(List<Car> racingCars) {
        StringBuilder result = new StringBuilder();
        for (Car car : racingCars) {
            result.append(car.getNameAndRecord());
        }
        return result.toString();
    }
}
