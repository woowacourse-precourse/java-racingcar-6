package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<String> convertStringToList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .collect(Collectors.toList());
    }

}
