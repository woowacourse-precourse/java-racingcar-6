package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private String getInput() {
        return Console.readLine();
    }

    private void close() {
        Console.close();
    }
}
