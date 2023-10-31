package racingcar.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int CAR_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNameList) {
        if(isContainsEmptyName(carNameList)) {
            throw new IllegalArgumentException(ErrorMessageConstants.CAR_NAME_BLANK_MESSAGE);
        }
        if(isNull(carNameList)){
            throw new IllegalArgumentException(ErrorMessageConstants.CAR_NAMES_NULL_MESSAGE);
        }
        if(isOverLength(carNameList)) {
            throw new IllegalArgumentException(ErrorMessageConstants.CAR_NAME_WRONG_LENGTH_MESSAGE);
        }
        if(isDuplicated(carNameList)) {
            throw new IllegalArgumentException(ErrorMessageConstants.CAR_NAME_DUPLICATED_MESSAGE);
        }
    }

    public static void validateRoundNumber(String roundNumber) {
        try {
            Integer rn = Integer.parseInt(roundNumber);
            if(rn <= 0) {
                throw new IllegalArgumentException(ErrorMessageConstants.ROUND_NUMBER_WRONG_RANGE_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstants.ROUND_NUMBER_WRONG_TYPE_MESSAGE);
        }
    }

    private static boolean isDuplicated(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>();
        for(String carName : carNameList) {
            if(carNameSet.contains(carName)) return true;
            carNameSet.add(carName);
        }
        return false;
    }

    private static boolean isContainsEmptyName(List<String> carNameList) {
        if(carNameList == null) {
            return true;
        }
        return false;
    }

    private static boolean isOverLength(List<String> carNameList) {
        for(String name : carNameList) {
            if(name.length() > CAR_NAME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNull(List<String> carNameList) {
        return carNameList.isEmpty();
    }
}
