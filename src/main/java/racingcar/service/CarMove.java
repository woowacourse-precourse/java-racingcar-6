package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class CarMove {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_MOVE_NUMBER = 4;

    public static int moveCheck() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (randomNumber >= MIN_MOVE_NUMBER) {
            return 1;
        }
        return 0;
    }

    public static void move(HashMap<String, Integer> car_list) {
        for (Map.Entry<String, Integer> item : car_list.entrySet()) {
            item.setValue(item.getValue() + moveCheck());
        }
    }
}
