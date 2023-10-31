package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String enterCarName() {
        String carNames = Console.readLine();
        return carNames;
    }

    public String enterAttemptNum() {
        String attemptNum = Console.readLine();
        return attemptNum;
    }

    public void inputClose() {
        Console.close();
    }
}
