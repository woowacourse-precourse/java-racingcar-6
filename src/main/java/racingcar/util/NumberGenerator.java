package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public int getRandomNumber () {
        return Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }

    public int findMaxNumber (int number1, int number2) {
        if(number1>number2) {
            return number1;
        }
        return number2;
    }
}
