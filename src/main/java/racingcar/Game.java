package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Game;

public class Game {
    PrintView printView = new PrintView();

    public void setForwordOrStay(User playUser) {
        Car[] carList = playUser.getCarList();
        for (int i = 0; i < carList.length; i++) {
            if (setRandNum() >= 4) {
                carList[i].setforwardBool(true);
                carList[i].addForwardCount();
            }
        }
    }

    public int setRandNum() {

    }
}