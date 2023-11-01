package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Notice;

public class Input {
    public static String inputCarNames() {
        System.out.println(Notice.INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String inputRunCount() {
        System.out.println(Notice.INPUT_RUN_COUNT);
        return Console.readLine();
    }
}
