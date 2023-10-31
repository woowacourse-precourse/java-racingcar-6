package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Output {
    public int randomNumber() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum;
    }
}
