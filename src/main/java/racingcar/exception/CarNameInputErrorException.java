package racingcar.exception;

import racingcar.exception.constant.ErrorMessageConstant;
import racingcar.util.TransferUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameInputErrorException implements InputErrorException{
    private final static int CAR_NAME_LENGTH_MIN_RANGE = 1;
    private final static int CAR_NAME_LENGTH_MAX_RANGE = 5;

    @Override
    public void checkUserInputValidate(String checkString) {
        List<String> checkStringList = new TransferUtil().transferStringToListString(checkString);
        if (isStringListEmpty(checkStringList)){
            throw new IllegalArgumentException(ErrorMessageConstant.INPUT_EMPTY_ERROR_MESSAGE.getMessage());
        }
        checkStringList.forEach(checkStrings -> {
            if (isCarNameShorterThanMinLength(checkStrings)) {
                throw new IllegalArgumentException(ErrorMessageConstant.CAR_NAME_LENGTH_SHORT_MESSAGE.getMessage());
            } else if (isCarNameLongerThanMaxLength(checkStrings)) {
                throw new IllegalArgumentException(ErrorMessageConstant.CAR_NAME_LENGTH_LONG_MESSAGE.getMessage());
            }
        });
        if (isCarNameDuplicate(checkStringList)){
            throw new IllegalArgumentException(ErrorMessageConstant.CAR_NAME_DUPLICATE_MESSAGE.getMessage());
        }
    }

    private static boolean isStringListEmpty(List<String> checkStringList) {
        return checkStringList.isEmpty();
    }

    private static boolean isCarNameDuplicate(List<String> checkStringList) {
        Set<String> stringSet = new HashSet<>(checkStringList);
        return stringSet.size() != checkStringList.size();
    }

    private static boolean isCarNameShorterThanMinLength(String checkString) {
        return checkString.length() < CAR_NAME_LENGTH_MIN_RANGE;
    }

    private static boolean isCarNameLongerThanMaxLength(String checkString) {
        return checkString.length() > CAR_NAME_LENGTH_MAX_RANGE;
    }
}
