package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String inputCarNames() {
        return Console.readLine();
    }

    public long inputMoveCounts() {
        return Long.parseLong(Console.readLine());
    }
}
