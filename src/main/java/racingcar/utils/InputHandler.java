package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private String readAndRemoveSpace() {
        return Console.readLine().replaceAll(" ", "");
    }

    public List<String> inputCarName() {
        String[] carNameArray = readAndRemoveSpace().split(",");
        List<String> inputNames = Arrays.asList(carNameArray);

        Validation.validateCarName(inputNames);
        return inputNames;
    }

    public String inputAttemptNumber() {
        String inputTryNumber = readAndRemoveSpace();

        Validation.validateAttemptNumber(inputTryNumber);
        return inputTryNumber;
    }
}