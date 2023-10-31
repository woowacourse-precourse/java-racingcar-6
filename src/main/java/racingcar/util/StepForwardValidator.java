package racingcar.util;

import static racingcar.constant.RaceConfig.LEAST_VALUE_TO_STEP_FORWARD;
import static racingcar.constant.RaceConfig.MAXIMUM_RANDOM_NUMBER;
import static racingcar.constant.RaceConfig.MINIMUM_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class StepForwardValidator {

    private StepForwardValidator() {
    }

    public static boolean isCarStepForward() {
        return generateRandomNumbers() >= LEAST_VALUE_TO_STEP_FORWARD;
    }

    private static int generateRandomNumbers() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }
}
