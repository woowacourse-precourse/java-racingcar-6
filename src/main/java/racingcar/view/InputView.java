package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String read() {
        return Console.readLine();
    }

    public static void readClose() {
        Console.close();
    }
}
