package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String enterCarName() {
        String carNames = Console.readLine();
        Console.close();
        return carNames;
    }

    public String enterAttemptNum() {
        String attemptNum = Console.readLine();
        Console.close();
        return attemptNum;
    }
}
