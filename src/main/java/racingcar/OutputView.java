package racingcar;

import static racingcar.constant.Constants.INPUT_NAMES;

public class OutputView {

    private void print(final String message) {
        System.out.print(message);
    }

    private void println(final String message) {
        System.out.println(message);
    }

    public void naming() {
        println(INPUT_NAMES);
    }

}
