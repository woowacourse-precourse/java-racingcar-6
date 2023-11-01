package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static final Integer MIN_RANDOM_NUMBER = 0;
    public static final Integer MAX_RANDOM_NUMBER = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
