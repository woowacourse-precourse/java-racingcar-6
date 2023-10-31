package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Round {

    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;
    private static final int BASE_NUMBER = 4;

    public static void play(List<Car> carList) {

        for (Car car : carList) {

            if (makeRandomValue() >= BASE_NUMBER) {
                car.add();
            }

        }

    }

    private static int makeRandomValue() {
        return Randoms.pickNumberInRange(MINIMUM_VALUE, MAXIMUM_VALUE);
    }

}
