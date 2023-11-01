package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    private String inputValue;

    Input() {
        inputValue = Console.readLine();
    }

    Input(String inputValue) {
        this.inputValue = inputValue;
    }

    public List<String> inputCarName() {
        String[] carNameArray = removeSpace(inputValue).split(",");
        List<String> inputNames = Arrays.asList(carNameArray);

        Validation.validateCarName(inputNames);
        return inputNames;
    }

    public String inputAttemptNumber() {
        String inputTryNumber = removeSpace(inputValue);

        Validation.validateAttemptNumber(inputTryNumber);
        return inputTryNumber;
    }

    private String removeSpace(String inputString) {
        return inputValue.replaceAll(" ", "");
    }
}
