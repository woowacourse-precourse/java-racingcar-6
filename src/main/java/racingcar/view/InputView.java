package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] inputCarNames() {
        return Console.readLine().split(",");
    }

    public int inputTry() {
        return 0;
    }
}
