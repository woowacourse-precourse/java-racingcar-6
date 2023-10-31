package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Checker {

    public static void validateCarName(String name) {
        isBelowFiveWord(name);
    }

    static void isBelowFiveWord(String name) {
        if (5 < name.length()){
            throw new IllegalArgumentException("자동차의 이름이 5글자 이상입니다.");
        }
    }

    public static boolean isStraight(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum >= 4;
    }
}
