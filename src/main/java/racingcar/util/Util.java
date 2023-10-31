package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Util {
    public static final String DASH = "-";

    public static int getMax(List<Integer> values) {
        return Collections.max(values);
    }

    public static ArrayList<String> toArrayList(String cars) {
        return new ArrayList<>(Arrays.asList(cars.split(",")));
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static String dashRepeat(int num) {
        StringBuilder dashes = new StringBuilder();
        IntStream.range(0, num)
                .forEach(i -> dashes.append(DASH));
        return dashes.toString();
    }
}