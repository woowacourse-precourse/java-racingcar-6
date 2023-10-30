package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {
    static int count;
    static List<String> carName;

    public InputValue() {
        String inputCount;
        String inputName;

        ResultPrinter.startMessage();
        inputName = readLine();
        carName = stringToList(inputName);
        checkInputException(carName);
        ResultPrinter.getTryMessage();
        inputCount = readLine();
        count = Integer.parseInt(inputCount);
    }

    private List<String> stringToList(String input) {
        return Arrays.asList(input.split(","));
    }

    private void checkInputException(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            checkMoreThanFiveChars(input.get(i));
        }

        checkFrequency(carName);
    }

    private void checkMoreThanFiveChars(String input) {
        if (input.length() >= 5) {
            throw new IllegalArgumentException();
        }
    }

    private void checkFrequency(List<String> carName) {
        for (String input : carName) {
            if (Collections.frequency(carName, input) > 1) {
                throw new IllegalArgumentException();
            }
        }
    }
}