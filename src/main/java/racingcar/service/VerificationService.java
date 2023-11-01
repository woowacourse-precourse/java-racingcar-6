package racingcar.service;

import racingcar.constant.CarValue;

public class VerificationService {
    public Boolean nameCheck(String carNames) {

        return (nameRangeCheck(carNames) && nullValueCheck(carNames));
    }

    private Boolean nameRangeCheck(String carNames) {
        int carNamesLength = carNames.length();

        return carNamesLength < CarValue.CAR_NAME_MAXIMUM_RANGE.getValue();
    }

    private Boolean nullValueCheck(String value) {

        if (value != null) {
            return true;
        } else throw new IllegalArgumentException("is null");


    }

    public Boolean countTypeCheck(String count) {
        Boolean isTrue = null;
        if (nullValueCheck(count) && countIsInteger(count)) {
            return true;
        } else throw new IllegalArgumentException();

    }

    private Boolean countIsInteger(String count) {
        try {
            Integer.parseInt(count);
            return true;
        } catch (IllegalArgumentException IAE) {
            System.out.println("숫자가 아니에욧");
            return false;
        }
    }
}
