package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
정    public String inputRacingCount() {
        return Console.readLine();
    }
    public String[] inputCarNames() {
        return Console.readLine().split(",");
    }
}
