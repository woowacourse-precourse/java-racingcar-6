package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    public static boolean wordLengthCheck(String name) {
        if (name.length() > 5) {
            return false;
        }
        return true;
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public static void nameValidation(String name) {
        nameMinCheck(name);
        nameMaxCheck(name);
    }

    private static void nameMinCheck(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("한 글자 이상 입력해주세요.");
        }
    }

    private static void nameMaxCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자 이하 이름을 입력해주세요.");
        }
    }


}
