package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String inputCarNames() {
        String rawCarNames = Console.readLine();
        return rawCarNames;
    }

    public static String[] parseCarName(String rawCarNames) {
        String[] carNames = rawCarNames.split(",");
        return carNames;
    }

}
