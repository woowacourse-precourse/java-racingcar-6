package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String inputCarNames() {
        return Console.readLine();
    }

    public long inputAttemptCounts() {
        return Long.parseLong(Console.readLine());
    }
}
