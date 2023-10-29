package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Iterator;

public class CheckMoveStop {
    public void checkMoveStop(HashMap<String, Integer> carName) {
        for (String car : carName.keySet()) {
            int randomNum = Randoms.pickNumberInRange(Constant.randomStartRange, Constant.randomEndRange);
            if (randomNum >= Constant.moveCondition) {
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
