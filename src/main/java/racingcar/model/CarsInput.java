package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class CarsInput {

    public void process() {
        List<String> userInputList = toArray();
    }

    public List<String> toArray() {
        String userInput = InputView.getUserInput();
        String[] split = userInput.split(",");
        return Arrays.asList(split);
    }
}
