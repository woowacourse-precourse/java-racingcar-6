package racingcar.view;

import static racingcar.constant.Message.DRIVER_NAME_RESULT;
import static racingcar.constant.Message.GAME_RESULT_HEADER;
import static racingcar.constant.Message.GAME_WINNER;
import static racingcar.constant.Message.NAME_COMMA;

import java.util.List;

public class OutputView {

    public static void outputResultHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    public static void displayRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public static void displayWinners(List<String> winnerNames) {
        System.out.println(GAME_WINNER + DRIVER_NAME_RESULT + String.join(NAME_COMMA, winnerNames));
    }
}
