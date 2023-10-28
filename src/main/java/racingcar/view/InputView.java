package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private List<String> splitCarNames(String userInput) {
        return Arrays.stream(userInput.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    public List<String> inputCarNames() {
        String userInput = Console.readLine();
        return splitCarNames(userInput);
    }
}
