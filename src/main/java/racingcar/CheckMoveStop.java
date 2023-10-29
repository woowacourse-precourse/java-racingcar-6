package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Iterator;

public class CheckMoveStop {
    public void checkMoveStop(HashMap<String, Integer> carName, Iterator<String> iter) {
        while (iter.hasNext()) {
            int randomNum = Randoms.pickNumberInRange(Constant.randomStartRange, Constant.randomEndRange);
            String car = iter.next();
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
