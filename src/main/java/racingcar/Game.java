package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public int randomNumber() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }


}
