package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarGameMachineValidator {

    private final int MIN_RACING_CAR_COUNT = 2;
    private final int MAX_RACING_CAR_COUNT = 5;

    public void validateNameList(List<String> racingCarNameList) {
        validateNameCount(racingCarNameList);
        validateDuplicateName(racingCarNameList);
    }

    private void validateNameCount(List<String> racingCarNameList) {
        int size = racingCarNameList.size();
        if (isInvalidNameCount(size)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidNameCount(int size) {
        return size < MIN_RACING_CAR_COUNT || size > MAX_RACING_CAR_COUNT;
    }

    private void validateDuplicateName(List<String> racingCarNameList) {
        Set<String> uniqueNames = new HashSet<>(racingCarNameList);
        if (hasDuplicate(racingCarNameList, uniqueNames)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicate(List<String> racingCarNameList, Set<String> uniqueNames) {
        return racingCarNameList.size() != uniqueNames.size();
    }

    public void validateRoundCount(int roundCount) {
    }
}
