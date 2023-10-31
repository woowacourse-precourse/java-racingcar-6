package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RoundNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Utils {
    public static List<String> toList(String carNames) {
        return Arrays.asList(carNames.split("\\s*,\\s*", -1));
    }

    public static String convertDistanceToSymbol(int distance) {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, distance).forEach(i -> result.append("-"));
        return result.toString();
    }

    public static int toInt(String roundNumber) {
        return Integer.parseInt(roundNumber);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
