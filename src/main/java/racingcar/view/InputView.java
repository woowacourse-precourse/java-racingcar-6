package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getUserInput() {
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
