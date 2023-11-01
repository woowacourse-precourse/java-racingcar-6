package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.common.config.RacingCarRule;
import racingcar.common.exception.ErrorMessage;
import racingcar.domain.racer.Racer;

public final class RacerValidator {

    private static final Pattern RACER_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    private RacerValidator() {
    }

    public static void validateRacerNameLength(String name) {
        int length = name.length();
        if (length > RacingCarRule.MAX_RACER_NAME_LENGTH) {
            throw ErrorMessage.INVALID_RACER_NAME_LENGTH.getException(String.valueOf(length));
        }
    }

    public static void validateRacerNameFormat(String name) {
        if (!RACER_NAME_PATTERN.matcher(name).matches()) {
            throw ErrorMessage.INVALID_RACER_NAME_FORMAT.getException(name);
        }
    }

    public static <T extends Racer> void validateRacerSize(List<T> racers) {
        int size = racers.size();
        if (size > RacingCarRule.MAX_RACER_SIZE || size < RacingCarRule.MIN_RACER_SIZE) {
            throw ErrorMessage.INVALID_RACER_SIZE.getException(String.valueOf(size));
        }
    }

    public static <T extends Racer> void validateDuplicatedRacerName(List<T> racers) {
        Set<T> set = new HashSet<>(racers);
        if (set.size() != racers.size()) {
            throw ErrorMessage.DUPLICATED_RACER_NAME.getException();
        }
    }

    public static void validateIsWithinRacingTurnRange(int totalTurn) {
        if (totalTurn < 0 || totalTurn > RacingCarRule.MAX_TOTAL_TURN) {
            throw ErrorMessage.INVALID_TOTAL_TURN_SIZE.getException(String.valueOf(totalTurn));
        }
    }
}
