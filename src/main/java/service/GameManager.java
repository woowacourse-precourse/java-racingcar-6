package service;

import camp.nextstep.edu.missionutils.Randoms;
import controller.Controller;

public class GameManager {

    public int setRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean chkCarGoOrStop(int randomNum) {
        return randomNum >= 4;
    }

    public void setCarsMove(boolean goOrStop, int carIdx) {
        String nowCarName = Controller.userInput.carsNameList.get(carIdx);

        if (goOrStop) {
            String nowCarBeforeMove = Controller.userInput.carNameAndPosList.get(nowCarName);
            Controller.userInput.carNameAndPosList.put(nowCarName, nowCarBeforeMove + "-");
        }
    }
}
