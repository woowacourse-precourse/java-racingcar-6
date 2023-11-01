package racingcar;

import java.util.List;

import static racingcar.ExceptionHandler.*;

public class Input {
    public static List<String> getCarNames(String input) {
        checkNull(input);
        return splitCarNames(input);
    }

    public static Long getTryCount(String input) {
        checkNull(input);
        checkNaturalNumber(input);
        return Long.parseLong(input);
    }

    private static List<String> splitCarNames(String input) {
        return checkNameLength(checkEmpty(List.of(input.split(","))));
    }


}
