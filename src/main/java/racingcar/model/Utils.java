package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final String CAR_NAME_SEPARATOR = ",";

    private Utils() {
    }

    public static int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (final NumberFormatException numberFormatException) {
            throw numberFormatException;
        }
    }

    public static List<Name> splitNamesOfCars(String namesOfCars) {
        return Arrays.stream(namesOfCars.split(CAR_NAME_SEPARATOR))
                .map(Name::new)
                .toList();
    }
}
