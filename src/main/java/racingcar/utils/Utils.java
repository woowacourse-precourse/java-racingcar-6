package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> splitAndToList(String carNames) {
        List<String> separatedCarNames = Arrays.stream(carNames.split("\\s*,\\s*"))
                                               .collect(Collectors.toList());
        return separatedCarNames;
    }
}
