package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.common.config.RacingCarRule;
import racingcar.common.exception.ErrorMessage;
import racingcar.racer.Racer;

public final class RacerValidator {

    private static final Pattern RACER_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    private RacerValidator() {
    }

    public static void validateRacerNameLength(String name) {
        if (name.length() > RacingCarRule.MAX_RACER_NAME_LENGTH) {
            throw ErrorMessage.INVALID_RACER_NAME_LENGTH.getException();
        }
    }

    public static void validateRacerNameFormat(String name) {
        if (!RACER_NAME_PATTERN.matcher(name).matches()) {
            throw ErrorMessage.INVALID_RACER_NAME_FORMAT.getException();
        }
    }

    public static <T extends Racer> void validateRacerSize(List<T> racers) {
        if (racers.size() > RacingCarRule.MAX_RACER_SIZE || racers.size() < RacingCarRule.MIN_RACER_SIZE) {
            throw ErrorMessage.INVALID_RACER_SIZE.getException();
        }
    }

    public static <T extends Racer> void validateDuplicatedRacerName(List<T> racers) {
        Set<T> set = new HashSet<>(racers);
        if (set.size() != racers.size()) {
            throw ErrorMessage.DUPLICATED_RACER_NAME.getException();
        }
    }

    public static void validateTotalTurnRange(int totalTurn) {
        if (totalTurn > RacingCarRule.MAX_TOTAL_TURN) {
            throw ErrorMessage.INVALID_TOTAL_TURN_SIZE.getException();
        }
    }
}
