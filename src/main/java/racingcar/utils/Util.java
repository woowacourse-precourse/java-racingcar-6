package racingcar.utils;

import java.util.stream.IntStream;

public class Util {
    public static String dashGenerator(int position) {
        StringBuilder dashes = new StringBuilder();
        IntStream.range(0, position).forEach(i -> dashes.append("-"));
        return dashes.toString();
    }
}
