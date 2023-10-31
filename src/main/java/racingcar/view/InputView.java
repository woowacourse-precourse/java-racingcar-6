package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> receiveCarNames(String input) {
        return divideByComma(input);
    }

    public int receiveTotalRound(String input) {
        return Integer.parseInt(input);
    }

    private List<String> divideByComma(String input) {
        return Arrays.asList(input.split(","));
    }
}
