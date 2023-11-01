package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> inputNamesStringToList() {
        String inputNames = Console.readLine();
        Validator.validateEndsWith(inputNames);
        return Arrays.stream(inputNames.split(","))
                .collect(Collectors.toList());
    }

    public int inputLoopStringToInt() {
        String inputLoop = Console.readLine();
        Validator.validatePositiveInteger(Integer.parseInt(inputLoop));
        return Integer.parseInt(inputLoop);
    }
}
