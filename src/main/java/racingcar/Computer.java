package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public static Integer CreateRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
