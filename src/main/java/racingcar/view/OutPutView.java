package racingcar.view;

import racingcar.message.OutputMessage;

import java.util.List;

public class OutPutView {

    public static void executionResultView() {
        System.out.println(OutputMessage.RESULT_MESSAGE.getValue());
    }

    public static void resultNameAndAdvanceView(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }

    public static void resultWinnerView(List<String> resultWinners) {
        System.out.print(OutputMessage.WINNER_MESSAGE.getValue() + String.join(", ", resultWinners));
    }
}
