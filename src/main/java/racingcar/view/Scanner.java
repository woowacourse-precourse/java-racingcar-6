package racingcar.view;

import static racingcar.configurations.ErrorMessages.*;
import static racingcar.configurations.InputConfigurations.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Scanner {
    private String delimiter;
    private int maximumNameLength;

    private static class SingletonScanner {
        private static final Scanner SCANNER = new Scanner();
    }

    public static Scanner getInstance() {
        return SingletonScanner.SCANNER;
    }

    private Scanner() {
        delimiter = getDelimiter();
        maximumNameLength = getMaximumNameLength();
    }

    public List<String> inputCarNames() {
        List<String> carNames = new ArrayList<>();
        String inputString = Console.readLine();
        validateNoInput(inputString);
        StringTokenizer tokenizedInputString = new StringTokenizer(inputString, delimiter);
        while (tokenizedInputString.hasMoreTokens()) {
            String nextCarName = tokenizedInputString.nextToken();
            validateCarName(nextCarName);
            carNames.add(nextCarName);
        }
        return carNames;
    }

    public Integer inputNumberOfRounds() {
        String numberOfRounds = Console.readLine();
        validateInputNumber(numberOfRounds);
        return Integer.parseInt(numberOfRounds);
    }

    private void validateNoInput(String inputString) {
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException(NO_INPUT_MESSAGE.get());
        }
    }

    private void validateCarName(String carName) {
        validateNoInput(carName);
        if (carName.length() > maximumNameLength) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE.get());
        }
    }

    private void validateInputNumber(String number) {
        validateNoInput(number);
        if (number.charAt(0) < '0' || number.charAt(0) > '9') {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_ROUNDS_MESSAGE.get());
        }
    }
}
