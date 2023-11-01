package racingcar.view;

import static racingcar.utils.Console.println;

import java.util.List;
import racingcar.enums.Symbols;

public class OutputView {
    public static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printResultMessage() {
        println("\n" + RESULT_MESSAGE);
    }

    public void printWinner(List<String> winners) {
        println(winnerMessage(winners));
    }

    private String winnerMessage(List<String> winners) {
        return FINAL_WINNER + String.join(Symbols.COMMA.getSymbol() + " ", winners);
    }
}
