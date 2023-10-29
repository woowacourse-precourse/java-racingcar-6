package service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {

    public int setRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean chkCarGoOrStop(int randomNum) {
        return randomNum >= 4;
    }

    public void setCarsMove(boolean goOrStop, int carIdx) {
        String nowCarName = UserInput.carsNameList.get(carIdx);

        if (goOrStop) {
            String nowCarBeforeMove = UserInput.carNameAndPosList.get(nowCarName);
            UserInput.carNameAndPosList.put(nowCarName, nowCarBeforeMove + "-");
        }
    }

    public void printCarsMove() {

    }
}
