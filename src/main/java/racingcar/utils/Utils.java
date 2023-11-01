package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> convertStringToList(String AllCarsName) {
        return Arrays.stream(AllCarsName.split(","))
                .collect(Collectors.toList());
    }
}
