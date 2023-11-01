package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public String[] inputCarNames() {
        return Console.readLine().split(",");
    }
    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
