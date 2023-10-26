package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readCarNames() {
        return read();
    }

    private String read() {
        return Console.readLine();
    }
}
