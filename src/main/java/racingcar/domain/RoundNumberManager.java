package racingcar.domain;

public class RoundNumberManager {

    public boolean checkRoundNumberExceptions(String roundNumberString) {
        if (notNumber(roundNumberString)) {
            return true;
        } else {
            int roundNumber = Integer.parseInt(roundNumberString);
            if (negativeNumber(roundNumber)) {
                return true;
            }
        }

        return false;
    }

    public boolean notNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

    public boolean negativeNumber(Integer number) {
        if (number < 0) {
            return true;
        }

        return false;
    }
}
