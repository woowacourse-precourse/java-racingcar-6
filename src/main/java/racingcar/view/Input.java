package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String enterCarName() {
        return Console.readLine();
    }

    public String enterAttemptNum() {
        return Console.readLine();
    }

    public void inputClose() {
        Console.close();
    }
}
