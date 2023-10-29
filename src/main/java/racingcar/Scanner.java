package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Scanner {
    private String delimiter;
    private int maximumNameLength;

    Scanner(Configurations configurations) {
        delimiter = configurations.getDelimiter();
        maximumNameLength = configurations.getMaximumNameLength();
    }

    List<String> inputCarNames() {
        List<String> carNames = new ArrayList<>();
        String inputString = Console.readLine();
        StringTokenizer tokenizedInputString = new StringTokenizer(inputString, delimiter);
        while (tokenizedInputString.hasMoreTokens()) {
            String nextCarName = tokenizedInputString.nextToken();
            validate(isInvalidCarName(nextCarName));
            carNames.add(nextCarName);
        }
        return carNames;
    }

    Integer inputNumberOfRound() {
        String inputString = Console.readLine();
        validate(isInvalidNumber(inputString));
        return Integer.parseInt(inputString);
    }

    private Boolean isInvalidCarName(String carName) {
        return (carName.length() > maximumNameLength);
    }

    private Boolean isInvalidNumber(String inputString) {
        if (inputString.isBlank()) {
            return true;
        }
        return (inputString.charAt(0) < '0' || inputString.charAt(0) > '9');
    }

    private void validate(Boolean condition) {
        if (condition) {
            throw new IllegalArgumentException();
        }
    }
}
