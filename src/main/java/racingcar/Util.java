package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static String readLine() {
        return Console.readLine();
    }

    public static int pickNumberInRange() {
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
    }

    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }
}
