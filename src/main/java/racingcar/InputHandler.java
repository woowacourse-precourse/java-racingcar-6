package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String MESSAGE_TO_INQUIRE_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_TO_INQUIRE_ATTEMPTS = "시도할 회수는 몇회인가요?";

    private static final String ERROR_NOT_ENOUGH_NUMBER_OF_NAME = "충분한 수가 아닙니다. 최소 2개 이상 입력해주세요.";
    private static final String ERROR_NOT_INTEGER = "정수를 입력해주세요.";
    private static final String ERROR_LESS_THAN_ONE = "0보다 큰 값을 입력해야합니다.";

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    private static final int MINIMUM_NUMBER_OF_NAME = 2;

    public List<String> getValidCarNamesFromUser() throws IllegalArgumentException {
        String userInput = getUserInputForCarNames();
        List<String> carNames = splitByCommaAndTrim(userInput);
        validateCarNames(carNames);
        return carNames;
    }

    private String getUserInputForCarNames() {
        System.out.println(MESSAGE_TO_INQUIRE_CARS_NAME);
        return Console.readLine();
    }

    private List<String> splitByCommaAndTrim(String str) {
        return Arrays
                .stream(str.split(","))
                .map(String::strip)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        checkIfEnoughNumberOfName(carNames);
    }

    private void checkIfEnoughNumberOfName(List<String> carNames) {
        if (carNames.size() < MINIMUM_NUMBER_OF_NAME) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_NUMBER_OF_NAME);
        }
    }

    public int getValidAttemptsFromUser() throws IllegalArgumentException {
        String userInput = getUserInputForAttempts();
        validateInteger(userInput);

        int attempts = Integer.parseInt(userInput);
        validatePositiveNumber(attempts);

        return attempts;
    }

    private String getUserInputForAttempts() {
        System.out.println(MESSAGE_TO_INQUIRE_ATTEMPTS);
        return Console.readLine();
    }

    private void validateInteger(String userInput) {
        if (!isInteger(userInput)) throw new IllegalArgumentException(ERROR_NOT_INTEGER);
    }

    private boolean isInteger(String str) {
        Matcher matcher = INTEGER_PATTERN.matcher(str);
        return matcher.matches();
    }

    private void validatePositiveNumber(int attempts) {
        if (attempts < 0) throw new IllegalArgumentException(ERROR_LESS_THAN_ONE);
    }
}
