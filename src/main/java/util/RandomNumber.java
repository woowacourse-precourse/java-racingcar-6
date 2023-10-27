package util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    public static int generateRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return randomNumber;
    }
}
