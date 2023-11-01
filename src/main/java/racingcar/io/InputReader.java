package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader implements Reader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
