package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import static racingcar.constant.GameMessage.*;
public class InputView {
    public static String getPlayerInput(){
        System.out.println(ASK_INPUT_INSTRUCT_MESSAGE.getValue());
        return Console.readLine();
    }

    public static int getPlayerAttempts(){
        System.out.println(ASK_ATTEMPT_COUNT_MESSAGE.getValue());
        return Integer.parseInt(Console.readLine());

    }
}
