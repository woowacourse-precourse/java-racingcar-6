package racingcar.common.exception;

import jdk.dynalink.linker.GuardingDynamicLinker;
import racingcar.common.constant.GuidePhrases;

public class AttemptNotNumberException {
    public static void notNumber(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(GuidePhrases.cannotParseToInt);
        }
    }
}
