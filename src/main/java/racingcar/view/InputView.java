package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Message;

public class InputView {
    public static String inputCarsName() {
        System.out.println(Message.INPUT_CAR_NAME_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputMovesCount() {
        System.out.println(Message.INPUT_COUNT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
