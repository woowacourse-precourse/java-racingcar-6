package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readLine() {
        return Console.readLine();
    }

    public String[] carNameList() {
        return readLine().split(",");
    }

    public int roundAmount() {
        return Integer.parseInt(readLine());
    }
}
