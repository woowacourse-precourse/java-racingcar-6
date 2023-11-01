package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class CarNameController {
    public static List<String> parseNamesToList(String names) {
        return Arrays.asList(names.replace(" ", "").split(","));
    }
}
