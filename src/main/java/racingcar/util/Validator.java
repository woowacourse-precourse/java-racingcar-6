package racingcar.util;


import static racingcar.constant.ErrorMessage.INPUT_CAR_NAME_LENGTH_EXCEPTION;
import static racingcar.constant.ErrorMessage.INPUT_GAME_COUNT_EXCEPTION;
import static racingcar.constant.ErrorMessage.INPUT_NOT_FORMAT;
import static racingcar.constant.NumberConstant.CAR_NAME_LENGTH;

import java.util.List;
import racingcar.constant.Delimiter;

public class Validator {


    public void isRightCarNameInput(List<String> splitedName) {
        checkLengthEachName(splitedName);
    }

    private void checkLengthEachName(List<String> inputCarNames) {
        for (String carName : inputCarNames) {
            if (isRightRangeCarName(carName)) {
                continue;
            }

            throw new IllegalArgumentException(
                String.format(INPUT_CAR_NAME_LENGTH_EXCEPTION.getMessage(),
                    CAR_NAME_LENGTH.getNumber()));
        }
    }

    private void checkRightInputFormat(List<String> splitNames) {
        checkSplitInputElementBlank(splitNames);
        checkInputBlank(splitNames);
    }

    private void checkSplitInputElementBlank(List<String> splitNames) {
        for (String carName : splitNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException(INPUT_NOT_FORMAT.getMessage());
            }
        }
    }

    private void checkInputBlank(List<String> splitNames) {
        if (splitNames.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NOT_FORMAT.getMessage());
        }
    }

    private boolean isRightRangeCarName(String carName) {
        return !carName.isEmpty() && carName.length() <= CAR_NAME_LENGTH.getNumber();
    }

    public void isRightInputGameCount(String carGameCount) {
        try {
            Integer.parseInt(carGameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_GAME_COUNT_EXCEPTION.getMessage());
        }
    }

    public void isRightInputFormat(String carInput, List<String> carNames) {
        checkRightCommaContains(carInput, carNames);
        checkRightInputFormat(carNames);
    }

    private void checkRightCommaContains(String carInput, List<String> carNames) {
        if (isRightCommaCount(carNames, countComma(carInput))) {
            throw new IllegalArgumentException(INPUT_NOT_FORMAT.getMessage());
        }
    }

    private int countComma(String carInput) {
        return (int) carInput.chars()
            .filter(inputLetter -> inputLetter == Delimiter.COMMA.getDelimiter().charAt(0))
            .count();
    }

    private boolean isRightCommaCount(List<String> carNames, long count) {
        return count != carNames.size() - 1;
    }
}
