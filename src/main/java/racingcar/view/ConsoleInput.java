package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.constant.ConsoleInputConstants.COMMA_REGEX;
import static racingcar.constant.ConsoleInputConstants.MAXIMUM_RANDOM_NUMBER;
import static racingcar.constant.ConsoleInputConstants.MINIMUM_RANDOM_NUMBER;
import static racingcar.validator.ConsoleInputValidator.validateCarNames;
import static racingcar.validator.ConsoleInputValidator.validateInputIsNumber;
import static racingcar.validator.ConsoleInputValidator.validateInputString;
import static racingcar.validator.ConsoleInputValidator.validatePlayNumber;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class ConsoleInput {

    private static String readValidLine() {
        try {
            return readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> inputCarNames() {

        String inputString = readValidLine();

        validateInputString(inputString);

        List<String> carNames = convertStringToCarNameList(inputString);

        validateCarNames(carNames);

        return carNames;

    }

    public static int inputPlayNumber() {
        String inputString = readValidLine();
        validateInputString(inputString);

        validateInputIsNumber(inputString);
        int inputNumber = Integer.parseInt(inputString);
        validatePlayNumber(inputNumber);

        return inputNumber;
    }

    public static int inputProgress() {
        return pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }

    private static List<String> convertStringToCarNameList(String inputString) {
        String[] split = inputString.split(COMMA_REGEX);

        return Arrays.stream(split).toList();
    }
}
