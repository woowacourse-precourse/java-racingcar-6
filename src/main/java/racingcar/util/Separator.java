package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    private static final String DELIMETER = ",";

    public static List<String> separateByDelimeter(String input) {
        String[] carsArr = input.split(DELIMETER);
        return new ArrayList<>(Arrays.asList(carsArr));
    }
}
