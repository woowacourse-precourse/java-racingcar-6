package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GetInput {
    public static String getCarNames() {
        return Console.readLine();
    }

    public static int getCounts() {
        return Integer.parseInt(Console.readLine());
    }

}
