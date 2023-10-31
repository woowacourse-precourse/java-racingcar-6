package racingcar.view;

import static racingcar.constant.Constant.READ_CAR_NAME_MESSAGE;
import static racingcar.constant.Constant.READ_MOVE_COUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private InputView() {
    }

    public static String readCarName() {
        System.out.println(READ_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static String readMoveCount() {
        System.out.println(READ_MOVE_COUNT_MESSAGE);
        return Console.readLine();
    }
}
