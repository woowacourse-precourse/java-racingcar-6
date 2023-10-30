package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarListEditor {
    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }


}
