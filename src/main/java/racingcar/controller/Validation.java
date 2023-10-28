package racingcar.controller;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.AllPunctuationMarks.COMMA;
import static racingcar.constant.ExceptionMessage.*;

import java.util.Map;

public class Validation {
    public void checkNullNameInInput(String carNameInput) {
        if (carNameInput.contains(COMMA)) {
            checkFirstOrLastComma(carNameInput);
            checkContinuousComma(carNameInput);
        }
    }

    private void checkFirstOrLastComma(String carNameInput) {
        int lastIndex = carNameInput.length()-1;
        if (carNameInput.charAt(0) == COMMA.charAt(0) || carNameInput.charAt(lastIndex) == COMMA.charAt(0)) {
            throw new IllegalArgumentException(NULL_CAR_NAME + carNameInput);
        }
    }
    private void checkContinuousComma(String carNameInput) {
        if (carNameInput.contains(COMMA + COMMA)) {
            throw new IllegalArgumentException(NULL_CAR_NAME + carNameInput);
        }
    }
    public void checkNameTokenLengthOver(String carNameToken) {
        if (carNameToken.length() > MAX_NAME_TOKEN_LENGTH) {
            throw new IllegalArgumentException(OVER_CAR_NAME_LIMIT + carNameToken);
        }
    }
    public void checkNameTokenDuplicated(String carNameToken, Map<String,Integer> carList) {
        if (carList.containsKey(carNameToken)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED + carNameToken);
        }
    }
    public void checkRoundsNumeric(String round) {
        try {
            int temp = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ROUNDS + round);
        }
    }

    public void checkRoundsZeroOrNegative(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException(ZERO_ROUNDS);
        }
    }
}