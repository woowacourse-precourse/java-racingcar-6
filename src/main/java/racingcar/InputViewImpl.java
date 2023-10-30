package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
