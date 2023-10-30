package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class UserService {

    public static String getCarNames() {
        return Console.readLine();
    }

    public static int getMoveCount() {
        return Integer.parseInt(Console.readLine());
    }
}
