package racingcar.validator;

import racingcar.constant.ErrorMessage;
import racingcar.constant.FixedNumber;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarGameMachineValidator {
    public void validateNameList(List<String> racingCarNameList) {
        validateNameCount(racingCarNameList);
        validateDuplicateName(racingCarNameList);
    }

    private void validateNameCount(List<String> racingCarNameList) {
        int size = racingCarNameList.size();
        if (isInvalidNameCount(size)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACING_CAR_NAME_COUNT.getMessage());
        }
    }

    private boolean isInvalidNameCount(int size) {
        return size < FixedNumber.MIN_RACING_CAR_COUNT.getValue()
                || size > FixedNumber.MAX_RACING_CAR_COUNT.getValue();
    }

    private void validateDuplicateName(List<String> racingCarNameList) {
        Set<String> uniqueNames = new HashSet<>(racingCarNameList);
        if (hasDuplicate(racingCarNameList, uniqueNames)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_RACING_CAR_NAME.getMessage());
        }
    }

    private boolean hasDuplicate(List<String> racingCarNameList, Set<String> uniqueNames) {
        return racingCarNameList.size() != uniqueNames.size();
    }

    public void validateRoundCount(int roundCount) {
        if (isInvalidRoundCount(roundCount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
        }
    }

    private boolean isInvalidRoundCount(int roundCount) {
        return roundCount < FixedNumber.MIN_ROUND_COUNT.getValue()
                || roundCount > FixedNumber.MAX_ROUND_COUNT.getValue();
    }
}
