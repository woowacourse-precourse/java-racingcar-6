package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> splitInputByComma(String input) {
        String[] splitInputArray = input.split(",");
        return Arrays.asList(splitInputArray);
    }
}
