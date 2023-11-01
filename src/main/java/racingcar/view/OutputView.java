package racingcar.view;

import java.util.List;
import racingcar.constant.CommonSymbol;
import racingcar.constant.Message;

public class OutputView {

    public OutputView() {
    }

    public static void printWinner(List<String> winners) {
        String winner = String.join(CommonSymbol.SYMBOL_COMMA_SPACE, winners);
        System.out.println(Message.WINNER_MESSAGE + winner);
    }

    public static void printCarPosition(String name, int position) {
        System.out.println(name + CommonSymbol.SYMBOL_COLON_SPACE + CommonSymbol.SYMBOL_HYPHEN.repeat(position));
    }

    public static void printExecutionResultMessage() {
        System.out.println(Message.EXECUTION_RESULT_MESSAGE);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
