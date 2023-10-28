package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {

    public static String generateName(int length, char word) {
        String name = IntStream.range(0, length)
                .mapToObj(i -> String.valueOf(word))
                .collect(Collectors.joining());
        return name;
    }

}

