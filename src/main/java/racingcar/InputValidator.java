package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {

    private static final int LIMIT_NAME_LEN = 5;
    private static final int MINIMUM_TRY_NUM = 1;
//    public static void validateCarName(String[] carsName) {
//        for (String name : carsName) {
//            if (name.length() > LIMIT_NAME_LEN)
//                throw new IllegalArgumentException();
//        }
//    }

    public static void validateCarName(String carName) {
        if (carName.length() > LIMIT_NAME_LEN) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateTryNum(String stringTryNum) {
        int tryNum;
        try {
            tryNum = Integer.parseInt(stringTryNum);
            if (tryNum < MINIMUM_TRY_NUM) {
                throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return tryNum;
    }
}
