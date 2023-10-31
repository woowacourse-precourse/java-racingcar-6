package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<String> parseCarInput(String input) {
        validateCarInput(splitCar(input));
        return splitCar(input);
    }

    private List<String> splitCar(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public void checkSize(String input) throws IllegalArgumentException {
        if(input.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void checkEmpty(String input) throws IllegalArgumentException {
        if(input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarInput(List<String> cars) {
        for(String car : cars) {
            checkEmpty(car);
            checkSize(car);
        }
    }

    public int parseTrialInput(String input) {
        validateTrialInput(input);
        return parseInt(input);
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public void checkDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTrialInput(String input) {
        checkEmpty(input);
        checkDigit(input);
    }
}
