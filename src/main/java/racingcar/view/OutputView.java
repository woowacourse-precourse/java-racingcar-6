package racingcar.view;

import static racingcar.util.messageContent.DisplayMessageContent.GAME_WINNER;
import static racingcar.util.messageContent.DisplayMessageContent.PLAY_RESULT_TITLE;

public class OutputView {

    public static void displayPlayResultTitle() {
        System.out.println(PLAY_RESULT_TITLE.getContent());
    }

    public static void displayGameWinner() {
        System.out.print(GAME_WINNER.getContent());
    }

}
