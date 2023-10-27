package racingcar.controller;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.ExceptionMessage.*;

import java.util.Map;

public class Validation {
    public void NameLengthZero(String carName) {
        int lastIndex = carName.length()-1;
        if (carName.contains(DELIMETER)) {
            if (carName.charAt(0) == DELIMETER.charAt(0) || carName.charAt(lastIndex) == DELIMETER.charAt(0)) {
                throw new IllegalArgumentException(NAME_LENGTH_ZERO + carName);
            }
            if (carName.contains(DELIMETER+DELIMETER)) {
                throw new IllegalArgumentException(NAME_LENGTH_ZERO + carName);
            }
        }
    }
    public void OverNameLengthLimit(String carName) {
        if (carName.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(OVER_NAME_LIMIT + carName);
        }
    }
    public void NameDuplicated(String carName, Map<String,Integer> carList) {
        if (carList.containsKey(carName)) {
            throw new IllegalArgumentException(NAME_DUPLICATED + carName);
        }
    }
    public int RoundsNumeric(String round) {
        int temp;
        try {
            temp = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC + round);
        }
        return temp;
    }
}