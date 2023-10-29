package racingcar;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

class Input {
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
            if (isBlank(carName)
                    || isLengthOutOf1To(carName, 5)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isBlank(String raw) {
        return raw.compareTo("") == 0;
    }

    private static boolean isLengthOutOf1To(String raw, Integer length) {
        return raw.length() < 1 || raw.length() > length;
    }

    static Long inputRepetitions() {
        String raw = Console.readLine();
        checkRepetitionsError(raw);
        return Long.decode(raw);
    }

    private static void checkRepetitionsError(String repetitions) throws IllegalArgumentException {
        if (isBlank(repetitions)
                || isNotNumber(repetitions)
                || isNotNaturalNumber(repetitions)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotNumber(String rawInputArray) {
        try {
            Long.decode(rawInputArray);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean isNotNaturalNumber(String repetitions) {
        if (!isNotNumber(repetitions)) {
            Long num = Long.decode(repetitions);
            if (num > 0 && num <= Long.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }
}
