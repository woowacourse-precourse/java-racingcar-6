package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Reader implements Reader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
