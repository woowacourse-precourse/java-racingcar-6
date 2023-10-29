package racingcar.view;

import static racingcar.view.ConsoleInputValidator.validateCarNames;
import static racingcar.view.ConsoleInputValidator.validateInputIsNumber;
import static racingcar.view.ConsoleInputValidator.validateInputString;
import static racingcar.view.ConsoleInputValidator.validatePlayNumber;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class ConsoleInput {

    private static String readValidLine() {
        try {
            return camp.nextstep.edu.missionutils.Console.readLine();
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

    private static List<String> convertStringToCarNameList(String inputString) {
        String[] split = inputString.split(",");

        return Arrays.stream(split).toList();
    }
}
