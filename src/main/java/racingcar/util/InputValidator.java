package racingcar.util;

import java.util.List;
import racingcar.consts.ErrorMessages;
import racingcar.consts.GameConstant;

public class InputValidator {

    public void validateCarNames(List<String> carNames) {
        if (!isCarNameSizeOneBetweenFive(carNames)) {
            throwIllegalArgumentException(ErrorMessages.WRONG_CAR_NAME_LENGTH_MESSAGE.get());
        } else if (hasDuplicateCarName(carNames)) {
            throwIllegalArgumentException(ErrorMessages.WRONG_CAR_TYPES_MESSAGE.get());
        } else if (!isMoreThanTwoCarTypes(carNames)) {
            throwIllegalArgumentException(ErrorMessages.DUPLICATION_CAR_NAME_MESSAGE.get());
        }
    }

    private boolean isMoreThanTwoCarTypes(List<String> carNames) {
        return carNames.size() >= GameConstant.MIN_NUMBER_TYPES_CAR.get();
    }

    private boolean hasDuplicateCarName(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }

    private boolean isCarNameSizeOneBetweenFive(List<String> carNames) {
        return carNames.stream().allMatch(carName -> carName.length() >= GameConstant.MIN_LENGTH_CAR_NAME.get()
                && carName.length() <= GameConstant.MAX_LENGTH_CAR_NAME.get());
    }

    private void throwIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
