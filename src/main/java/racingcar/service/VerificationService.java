package racingcar.service;

public class VerificationService {
    public Boolean nameCheck(String carNames) {

        return nameRangeCheck(carNames) && nullValueCheck(carNames);
    }

    private final Boolean nameRangeCheck(String carNames) {
        int carNamesLength = carNames.length();

        return carNamesLength < 5;
    }

    private final Boolean nullValueCheck(String value) {

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

    private final Boolean countIsInteger(String count) {
        try {
            Integer.parseInt(count);
            return true;
        } catch (IllegalArgumentException IAE) {
            System.out.println("숫자가 아니에욧");
            return false;
        }
    }
}
