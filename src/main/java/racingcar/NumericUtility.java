package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumericUtility {

    public static int generateRandomNumber() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number;
    }

    public static boolean isNumberGreaterOrEqualToFour(int number) {
        return number >= 4;
    }

    public static int getConvertedNumber() {
        int number = generateRandomNumber();
        if (isNumberGreaterOrEqualToFour(number)) {
            return 1;
        }
        return 0;
    }
}
