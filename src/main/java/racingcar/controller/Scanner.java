package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Scanner {
    private String delimiter;
    private int maximumNameLength;

    Scanner(String delimiter, Integer maximumNameLength) {
        this.delimiter = delimiter;
        this.maximumNameLength = maximumNameLength;
    }

    List<String> inputCarNames() {
        List<String> carNames = new ArrayList<>();
        String inputString = Console.readLine();
        validate(isNoInput(inputString));
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

    private Boolean isNoInput(String input){
        return input.isEmpty();
    }
    private Boolean isInvalidCarName(String carName) {
        validate(isNoInput(carName));
        return (carName.length() > maximumNameLength);
    }

    private Boolean isInvalidNumber(String inputString) {
        validate(isNoInput(inputString),"라운드 수 입력 없음");
        return (inputString.charAt(0) < '0' || inputString.charAt(0) > '9');
    }
    private void validate(Boolean condition) {
        if (condition) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(Boolean condition, String message) {
        if (condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
