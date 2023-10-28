package racingcar.input;

import static racingcar.input.RacingCarInputReader.RACING_CAR_INPUT_SPLITTER;

import java.util.Arrays;
import org.assertj.core.util.VisibleForTesting;

public class RacingCarInputValidator {
    public static boolean isInputRacingCarsValidated(String input) {
        String[] names = input.split(RACING_CAR_INPUT_SPLITTER);
        if (hasLongName(names)) {
            return false;
        } else if (hasDuplicatedName(names)) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    protected static boolean hasLongName(String[] names) {
        return Arrays.stream(names)
                .anyMatch(name -> name.length() > 5);
    }

    @VisibleForTesting
    protected static boolean hasDuplicatedName(String[] names) {
        return names.length != Arrays.stream(names).distinct().count();
    }
}
