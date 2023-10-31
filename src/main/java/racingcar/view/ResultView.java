package racingcar.view;

import racingcar.message.ViewMessage;

import java.util.ArrayList;

public class ResultView {
    public static void printResultTitle() {
        System.out.println(ViewMessage.RESULT);
    }

    public static void printCarState(String name, int position) {
        System.out.println(name + ViewMessage.DELIMITER + ViewMessage.DASH.repeat(position));
    }

    public static void printWinner(ArrayList<String> names) {
        System.out.print(ViewMessage.WINNER + ViewMessage.DELIMITER + String.join(ViewMessage.COMMAS, names));
    }
}
