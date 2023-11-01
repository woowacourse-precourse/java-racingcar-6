package racingcar.domain;

public class RoundNumberManager {

    public void checkRoundNumberExceptions(String roundNumberString) {
        notNumber(roundNumberString);

        int roundNumber = Integer.parseInt(roundNumberString);
        negativeNumber(roundNumber);
    }

    private void notNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 숫자가 맞는지 확인해주세요.");
        }
    }

    private void negativeNumber(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException("입력한 값이 0이상의 수가 맞는지 확인해주세요.");
        }
    }
}
