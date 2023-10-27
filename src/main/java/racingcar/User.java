package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public String runRaceBasedOnInput() {
        return Console.readLine();
    }
    public String[] inputCarNames() {
        return Console.readLine().split(",");
    }
}
