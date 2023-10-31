package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.consts.ErrorMessages;
import racingcar.consts.GameConstant;
import racingcar.consts.ViewConstant;

public class InputValidator {

    public void validateCarNames(String playerInput) {
        List<String> carNames = Arrays.stream(playerInput.split(ViewConstant.DELIMITER.get())).toList();
        if (!isCarNameSizeOneBetweenFive(carNames)) {
            throwIllegalArgumentException(ErrorMessages.WRONG_CAR_NAME_LENGTH_MESSAGE.get());
        } else if (hasDuplicateCarName(carNames)) {
            throwIllegalArgumentException(ErrorMessages.DUPLICATION_CAR_NAME_MESSAGE.get());
        } else if (!isMoreThanTwoCarTypes(carNames)) {
            throwIllegalArgumentException(ErrorMessages.WRONG_CAR_TYPES_MESSAGE.get());
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

    public void validateNumberOfAttempt(String playerInput) {
        if (!isNumeric(playerInput)) {
            throwIllegalArgumentException(ErrorMessages.WRONG_NUMBER_OF_ATTEMPT_MESSAGE.get());
        }
    }

    private boolean isNumeric(String playerInput) {
        String regex = "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(playerInput);
        return matcher.matches();
    }


    private void throwIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
