package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.util.ErrorMessage;

public class InputView {

    public String inputCarsName() {
        String carsName = Console.readLine();

        return blankReplaceAllCarsName(carsName);
    }

    private String blankReplaceAllCarsName(String carsName) {
        return carsName.replaceAll(" ", "");
    }

    public Integer inputTryNumber() {
        String strTryNumber = Console.readLine();

        return stringToNumber(strTryNumber);
    }

    private Integer stringToNumber(String strTryNumber) {
        boolean containsNonNumeric = strTryNumber.chars()
                .anyMatch(ch -> !Character.isDigit(ch));

        if (containsNonNumeric) {
            throw new IllegalArgumentException(ErrorMessage.VALIDATE_NOT_NUMBER
                    .getMessage());

        }

        return Integer.valueOf(strTryNumber);
    }
}
