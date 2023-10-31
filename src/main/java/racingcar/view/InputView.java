package racingcar.view;

import java.util.Arrays;
import java.util.List;

public enum InputView {
    ;

    public static List<String> receiveCarNames(String input) {
        return divideByComma(input);
    }

    public static int receiveTotalRound(String input) {
        return Integer.parseInt(input);
    }

    private static List<String> divideByComma(String input) {
        return Arrays.asList(input.split(","));
    }
}
