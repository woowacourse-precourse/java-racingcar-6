package racingcar;

import static java.util.Objects.isNull;
import static racingcar.Constants.CAR_NAME_MAX;

import java.util.Arrays;


public class Exception {

    public static void checkCarNameLengthOver(String[] names) {
        Arrays.stream(names)
                .filter(name -> name.length() > CAR_NAME_MAX)
                .findAny()
                .ifPresent(name -> throwIllegalArgumentException());
    }

    public static void checkInteger(Integer integer) {
        if (isNull(integer)) {
            throwIllegalArgumentException();
        }
    }

    public static void checkWithinRange(Integer tryNumber) {
        if (tryNumber <= 0 || tryNumber > 100) {
            throwIllegalArgumentException();
        }
    }

    private static void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }
}
