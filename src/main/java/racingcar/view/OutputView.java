package racingcar.view;

import racingcar.message.GameMessage;



public class OutputView {

    public static void console(Object message) {
        System.out.printf(message.toString());
    }
    public static void consoleLine(Object message) {
        System.out.println(message.toString());
    }


}
