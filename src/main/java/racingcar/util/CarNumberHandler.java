package racingcar.util;

import racingcar.Car;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNumberHandler {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;

    public CarNumberHandler() {
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public static void moveCars(List<Car> CarArray) {
        for (Car car : CarArray) {
            int number = generateRandomNumber();
            if (number >= 4) {
                car.upMoveCount();
            }
        }
    }
}
