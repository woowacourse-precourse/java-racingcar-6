package racingcar.view.in;

import camp.nextstep.edu.missionutils.Console;

public class GameInputView {
    public static String requestInput(GameInputMessage gameInputMessage) {
        System.out.println(gameInputMessage.getMessage());
        return Console.readLine();
    }
}
