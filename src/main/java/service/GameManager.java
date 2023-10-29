package service;

import camp.nextstep.edu.missionutils.Randoms;
import controller.Controller;

import java.util.AbstractMap;
import java.util.Map;

public class GameManager {

    public int setRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean chkCarGoOrStop(int randomNum) {
        return randomNum >= 4;
    }

    public void setCarsMove(boolean goOrStop, int carIdx) {
        Map.Entry<String, String> car = Controller.userInput.carIdxNamePosList.get(carIdx);

        if (goOrStop) {
            String nowCarBeforePos = car.getValue();
            String newCarPos = nowCarBeforePos + "-";

            Controller.userInput.carIdxNamePosList.set(carIdx, new AbstractMap.SimpleEntry<>(car.getKey(), newCarPos));
        }
    }
}
