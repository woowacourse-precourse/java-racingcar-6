package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputString(String Message) {
        System.out.println(Message);
        return Console.readLine();
    }
}
