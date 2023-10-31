package racingcar.validator;

import javax.print.DocFlavor.READER;

public class InputNumberOfGameValidator {
    private final int ZERO = 0;

    public void validateNumberOfGame(String numberOfGame) {
        if (isNotDigit(numberOfGame)) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
        if (startWithZero(numberOfGame)) {
            throw new IllegalArgumentException("0 또는 0으로 시작되는 숫자는 입력할수 없습니다.");
        }
        if(isNegativeNum(numberOfGame)){
            throw new IllegalArgumentException("음수는 입력할수 없습니다.");
        }

    }

    public boolean isNotDigit(String numberOfGame) {
        try {
            int num = Integer.parseInt(numberOfGame);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public boolean startWithZero(String numberOfGame) {
        return numberOfGame.startsWith("0");
    }

    public boolean isNegativeNum(String numberofGame) {
        return Integer.parseInt(numberofGame) < ZERO;
    }
}
