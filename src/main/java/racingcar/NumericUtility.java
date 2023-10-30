package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumericUtility {

    public static int generateRandomNumber() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number;
    }

    public static int convertNumberIfGreaterOrEqualToFour(int number) {
        if (number >= 4) {
            return number;
        }
        return 0;
    }
}
