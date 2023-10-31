package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Util {
    public static final String COMMA = ",";
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final String DASH = "-";

    public static ArrayList<String> toArrayList(String cars) {
        return new ArrayList<>(Arrays.asList(cars.split(COMMA)));
    }

    public static int getMax(ArrayList<Integer> integers) {
        return Collections.max(integers);
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    public static String repeatDash(int num) {
        StringBuilder dashes = new StringBuilder();
        IntStream.range(0, num).forEach(i -> dashes.append(DASH));
        return dashes.toString();
    }
}
