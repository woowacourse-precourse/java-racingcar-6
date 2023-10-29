package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String next() {
        return Console.readLine();
    }

    public Integer nextInt() {
        return Integer.parseInt(next());
    }

    public String[] nextStringArray() {
        return next().split(",");
    }
}
