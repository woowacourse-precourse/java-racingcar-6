package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.common.exception.ErrorMessage;
import racingcar.racer.Raceable;

public class RacingCarValidator {

    private static final Pattern RACING_CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    private RacingCarValidator() {
    }

    public static void validateNameLength(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw ErrorMessage.INVALID_RACING_CAR_NAME_LENGTH.getException();
        }
    }

    public static void validateNameFormat(String name) {
        if (!RACING_CAR_NAME_PATTERN.matcher(name).matches()) {
            throw ErrorMessage.INVALID_RACING_CAR_NAME_FORMAT.getException();
        }
    }

    public static <T extends Raceable> void validateUnderThanMaxRacingCarNumber(List<T> racers) {
        if (racers.size() > 100) {
            throw ErrorMessage.INVALID_NUMBER_OF_RACING_CAR.getException();
        }
    }

    public static <T extends Raceable> void validateDuplicatedName(List<T> racers) {
        Set<T> set = new HashSet<>(racers);
        if (set.size() != racers.size()) {
            throw ErrorMessage.DUPLICATED_RACING_CAR_NAME.getException();
        }
    }
}
