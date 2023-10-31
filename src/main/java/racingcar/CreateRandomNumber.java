package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNumber {
    public static int getNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
