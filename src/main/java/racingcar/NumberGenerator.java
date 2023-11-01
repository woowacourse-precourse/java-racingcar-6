package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator {

    public static int createRandomNumber() {
        int number = Randoms.pickNumberInRange(0, 9);

        return number;
    }
}
