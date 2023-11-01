package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Notice;

public class Input {
    public static String setCarNames() {
        Output.print(Notice.INPUT_CAR_NAMES);

        return Console.readLine();
    }

    public static String setRunCount() {
        Output.print(Notice.INPUT_RUN_COUNT);

        return Console.readLine();
    }
}
