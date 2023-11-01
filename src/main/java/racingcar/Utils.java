package racingcar;

import static racingcar.constant.GameNumber.RANDOM_NUMBER_MAXIMUM;
import static racingcar.constant.GameNumber.RANDOM_NUMBER_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
    }

    public static double revertToDouble(String number) {
        return Double.parseDouble(number);
    }

    public static void printLineChanging() {
        System.out.println();
    }
}
