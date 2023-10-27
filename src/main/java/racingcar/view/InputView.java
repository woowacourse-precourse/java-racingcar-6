package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.GameMessage;

public class InputView {
    public static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
