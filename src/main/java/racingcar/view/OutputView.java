package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String SEPARATOR = ", ";

    private OutputView() {
    }

    public static void printWinner(List<String> winners) {
        String names = String.join(SEPARATOR, winners);
        print(WINNER_MESSAGE + names);
    }

    private static void print(String output) {
        System.out.println(output);
    }

}
