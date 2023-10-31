package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String SPLIT_SYMBOL = ",";
    public String[] inputCarNames() {
        return Console.readLine().split(SPLIT_SYMBOL);
    }

    public String inputTryCount() {
        return Console.readLine();
    }
}
