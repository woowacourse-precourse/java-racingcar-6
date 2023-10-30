package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Message;

public class InputView {
    public static String inputCarsName() {
        System.out.println(Message.CAR_NAME_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputMovesCount() {
        System.out.println(Message.TRY_COUNT_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
