package racingcar.view;

import racingcar.enums.Exceptions;
import racingcar.exception.TryNumberTypeException;
import racingcar.util.Splitter;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String[] inputCarNames() {
        return Splitter.splitName(readLine());
    }

    public static Integer inputTryNumber() {
        String inputNumber = readLine();
        validateInputIsNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private static void validateInputIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new TryNumberTypeException(Exceptions.TRY_NUMBER_IS_INTEGER.getMessage());
        }
    }
}
