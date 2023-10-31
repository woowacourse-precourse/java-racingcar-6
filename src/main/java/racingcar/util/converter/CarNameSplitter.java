package racingcar.util.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameSplitter {

    private static final String CAR_NAME_REGEX = ",";

    public static List<String> splitCarNames(String carNames) {
        String[] splitCarNames = carNames.split(CAR_NAME_REGEX);
        return Arrays.stream(splitCarNames).collect(Collectors.toList());
    }
}
