package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.GameMessage;

import static racingcar.constant.GameMessage.*;
public class InputView {
    private static final String ASK_INPUT_INSTRUCT_MESSAGE = GameMessage.ASK_INPUT_INSTRUCT_MESSAGE.getValue();
    private static final String ASK_ATTEMPT_COUNT_MESSAGE = GameMessage.ASK_ATTEMPT_COUNT_MESSAGE.getValue();
    public static String getPlayerInput(){
        System.out.println(ASK_INPUT_INSTRUCT_MESSAGE);
        return Console.readLine();
    }

    public static int getPlayerAttempts(){
        System.out.println(ASK_ATTEMPT_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());

    }
}
