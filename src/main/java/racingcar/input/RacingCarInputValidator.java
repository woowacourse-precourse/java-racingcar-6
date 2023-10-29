package racingcar.input;

import static racingcar.input.RacingCarInputReader.RACING_CAR_INPUT_SPLITTER;

import java.util.Arrays;
import org.assertj.core.util.VisibleForTesting;

public class RacingCarInputValidator {

    private static final int MAX_NAME_LENGTH = 4;
    public static boolean isInputRacingCarsValidated(String input) {
        String[] names = input.split(RACING_CAR_INPUT_SPLITTER);
        if (hasLongName(names)) {
            return false;
        } else if (hasDuplicatedName(names)) {
            return false;
        }
        return true;
    }

    public static boolean isInputPlayNumberValidated(String input) {
        if (isUnavailableToParseInteger(input)) {
            return false;
        } else if (hasUnderValue(input)) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    protected static boolean hasLongName(String[] names) {
        return Arrays.stream(names)
                .anyMatch(name -> !(name.length() <= MAX_NAME_LENGTH));
    }

    @VisibleForTesting
    protected static boolean hasDuplicatedName(String[] names) {
        return names.length != Arrays.stream(names).distinct().count();
    }

    @VisibleForTesting
    protected static boolean isUnavailableToParseInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @VisibleForTesting
    protected static boolean hasUnderValue(String input) {
        int value = Integer.parseInt(input);
        return value <= 0;
    }
}
