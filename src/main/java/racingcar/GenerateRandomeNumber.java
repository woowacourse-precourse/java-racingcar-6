package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomeNumber {

    public static Integer generateNumber() {
        int answerNumber = Randoms.pickNumberInRange(0,9);
        return answerNumber;
    }
}