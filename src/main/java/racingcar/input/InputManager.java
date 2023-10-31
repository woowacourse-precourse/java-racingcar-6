package racingcar.input;

import static racingcar.util.CountValidator.validateAttemptCountOverZero;
import static racingcar.util.NameValidator.validateNameLengthBelowFive;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputManager {

    public List<String> inputCarNames() {
        final String names = Console.readLine();
        final List<String> nameList = Arrays
                .stream(names.split(","))
                .toList();
        validateNameLengthBelowFive(nameList);
        return nameList;
    }

    public int inputAttemptCount() {
        final int numberOfAttempt = Integer.parseInt(Console.readLine());
        validateAttemptCountOverZero(numberOfAttempt);
        return numberOfAttempt;
    }
}
