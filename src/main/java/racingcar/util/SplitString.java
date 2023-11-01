package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class SplitString {

    public static List<String> splitString(String cars) throws IllegalArgumentException {
        String[] carsList = cars.split(",");
        return Validation.carsLength(Arrays.asList(carsList));
    }
}
