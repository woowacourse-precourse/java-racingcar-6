package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Conversion {
    public static ArrayList<String> stringToArrayList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
