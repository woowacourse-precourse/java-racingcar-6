package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    public static List<String> separateByComma(String input) {
        String[] carsArr = input.split(",");
        return new ArrayList<>(Arrays.asList(carsArr));
    }
}
