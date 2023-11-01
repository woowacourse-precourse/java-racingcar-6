package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.repository.Car;

import java.util.List;

public class Move {
    private final static int START_VALUE = 0;
    private final static int END_VALUE = 9;
    private final static int STANDARD_NUMBER = 3;

    public static void race(List<Car> carList) {
        for (Car car : carList) {
            int moveNum = Randoms.pickNumberInRange(START_VALUE, END_VALUE);
            if (moveNum < STANDARD_NUMBER + 1) {
                continue;
            }
            car.setDistance();
        }
    }
}
