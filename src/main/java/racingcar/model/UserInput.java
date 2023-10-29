package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class UserInput {

    public void process() {
        List<String> userInputList = toArray();
        validLength(userInputList);
    }

    public List<String> toArray() {
        String userInput = InputView.getUserInput();
        String[] split = userInput.split(",");
        return Arrays.asList(split);
    }

    private void validLength(List<String> userInputList) {
        boolean lengthOver = userInputList.stream().anyMatch(s -> s.length() > 5);
        if (lengthOver) {
            throw new IllegalArgumentException();
        }
    }

}
