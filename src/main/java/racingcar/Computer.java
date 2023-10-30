package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    private final List<String> carNames = new ArrayList<>();
    private int round;

    public void readCarNames(String input) {
        List<String> carNameStream = extractCarNames(input);

        if (isInvalidCarNames(carNameStream)) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> extractCarNames(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }

    private boolean isInvalidCarNames(List<String> names) {
        return isDuplicate(names) || names.stream().anyMatch(name ->
                name.isBlank() || hasSizeGreaterThanFive(name));
    }

    private boolean isDuplicate(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    private boolean hasSizeGreaterThanFive(String name) {
        return name.length() > 5;
    }

    public void readRound(String input) {
        final int number = Integer.parseInt(input);

        if (isInvalidRound(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidRound(int number) {
        return isNegative(number) || isZero(number);
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    private boolean isZero(int number) {
        return number == 0;
    }
}
