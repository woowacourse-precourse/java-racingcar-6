package racingcar;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    static List<String> inputCarName() {
        String raw = Console.readLine();

        checkSplitFormatError(raw);
        List<String> carNames = rawToList(raw);

        checkCarNameError(carNames);
        return carNames;
    }

    private static void checkSplitFormatError(String raw) throws IllegalArgumentException {
        if (isEndWithComma(raw)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEndWithComma(String raw) {
        return raw.endsWith(",");
    }

    private static List<String> rawToList(String raw) {
        String[] rawArray = raw.split(",");
        return new ArrayList<>(Arrays.asList(rawArray));
    }

    private static void checkCarNameError(List<String> carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (isNull(carName) || isBlank(carName) || isLength1To(carName, 5)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isNull(String raw) {
        return raw == null;
    }

    private static boolean isBlank(String raw) {
        return raw.compareTo("") == 0;
    }

    private static boolean isLength1To(String raw, int length) {
        return raw.length() <= length;
    }
}
