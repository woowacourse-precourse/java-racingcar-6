package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private static final String CAR_NAME_SEPARATOR = ",";

    public static int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw numberFormatException;
        }
    }

    public static List<String> splitNamesOfCars(String namesOfCars) {
        return Arrays.stream(namesOfCars.split(CAR_NAME_SEPARATOR))
                .collect(Collectors.toList());
    }
}
