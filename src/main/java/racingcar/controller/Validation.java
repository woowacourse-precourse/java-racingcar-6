package racingcar.controller;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.ExceptionMessage.*;

import java.util.Map;

public class Validation {
    public void nameLengthZero(String carNameInput) {
        if (carNameInput.contains(DELIMETER)) {
            findCommaFirstOrLast(carNameInput);
            continuousComma(carNameInput);
        }
    }

    private void findCommaFirstOrLast(String carNameInput) {
        int lastIndex = carNameInput.length()-1;
        if (carNameInput.charAt(0) == DELIMETER.charAt(0) || carNameInput.charAt(lastIndex) == DELIMETER.charAt(0)) {
            throw new IllegalArgumentException(NULL_CAR_NAME + carNameInput);
        }
    }
    private void continuousComma(String carNameInput) {
        if (carNameInput.contains(DELIMETER+DELIMETER)) {
            throw new IllegalArgumentException(NULL_CAR_NAME + carNameInput);
        }
    }
    public void overNameLengthLimit(String carNameToken) {
        if (carNameToken.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(OVER_CAR_NAME_LIMIT + carNameToken);
        }
    }
    public void nameDuplicated(String carNameToken, Map<String,Integer> carList) {
        if (carList.containsKey(carNameToken)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED + carNameToken);
        }
    }
    public int roundsNumeric(String round) {
        int temp;
        try {
            temp = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ROUNDS + round);
        }
        return temp;
    }

    public void roundsNumberZero(int rounds) {
        if (rounds == 0) {
            throw new IllegalArgumentException(ZERO_ROUNDS);
        }
    }
}