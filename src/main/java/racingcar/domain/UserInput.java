package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    public UserInput() {
    }

    public String input() {
        String input = Console.readLine();
        return input;
    }

    public List<String> carName(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(names));
        checkInputCarName(carNames);
        return carNames;
    }

    public int attemptCount(String input) {
        checkInputAttemptCount(input);
        int attemptCount;
        attemptCount = Integer.parseInt(input);
        return attemptCount;
    }

    public void checkInputCarName(List<String> inputNames) {
        for (String name : inputNames) {
            if (name.isEmpty() || name.equals(" ")) {
                throw new IllegalArgumentException();
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (name.matches(".*\\d+.*")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkInputAttemptCount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (input.isEmpty() || input.equals(" ")) {
            throw new IllegalArgumentException();
        }
    }
}