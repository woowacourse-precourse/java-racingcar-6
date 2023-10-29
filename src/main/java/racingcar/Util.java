package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

    public static int getRandomSingleDigit(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean getBooleanByNumber(int number){
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("0 또는 한 자리 양수를 입력해야 한다.");
        }
        return number >= 4;
    }
}
