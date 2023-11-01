package racingcar.view;

import static racingcar.view.IOMessage.PRINT_FINAL_WINNER;

import java.util.List;
import racingcar.model.Result;

public class OutPutView {

    private static final String FORWARD_STEP = "-";

    private OutPutView() {}

    public static void printIOMessage(IOMessage message) {
        System.out.println(message.getMessage());
    }

    public static void println() {
        System.out.println();
    }

    public static void printResult(Result result) {
        String resultMessage = result.name() + " : " + FORWARD_STEP.repeat(result.movedCount());
        System.out.println(resultMessage);
    }

    public static void printWinner(List<String> winnerList) {

        if(winnerList.isEmpty()) throw new IllegalArgumentException();

        String winnerResult = String.join(", ", winnerList);
        System.out.println(PRINT_FINAL_WINNER.getMessage() + winnerResult);
    }

}
