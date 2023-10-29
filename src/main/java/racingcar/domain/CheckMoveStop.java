package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.constant.ConstantNumber.*;

import java.util.HashMap;

public class CheckMoveStop {
    public void checkMoveStop(HashMap<String, Integer> carName) {
        for (String car : carName.keySet()) {
            int randomNum = Randoms.pickNumberInRange(randomStartRange, randomEndRange);
            if (randomNum >= moveCondition) {
                carName.put(car, carName.get(car) + 1);
            }
        }
        printMove(carName);
    }

    private void printMove(HashMap<String, Integer> carName) {
        for (String car : carName.keySet()) {
            System.out.println(car + " : " + "-".repeat(carName.get(car)));
        }
        System.out.println();
    }
}
