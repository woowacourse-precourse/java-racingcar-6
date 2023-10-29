package racingcar.view;

import static racingcar.util.messageContent.DisplayMessageContent.DIVIDING_LINE;
import static racingcar.util.messageContent.DisplayMessageContent.GAME_WINNER;
import static racingcar.util.messageContent.DisplayMessageContent.MOVE_DISPLAY_STRING;
import static racingcar.util.messageContent.DisplayMessageContent.PLAYER_DIVIDING;
import static racingcar.util.messageContent.DisplayMessageContent.PLAY_RESULT_TITLE;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public static void displayPlayResultTitle() {
        System.out.println(PLAY_RESULT_TITLE.getContent());
    }

    public static void displayGameWinner(List<String> winners) {
        System.out.print(GAME_WINNER.getContent());
        for (int player = 0; player < winners.size(); player++) {
            System.out.print(winners.get(player));
            if (player < winners.size() - 1) {
                System.out.print(PLAYER_DIVIDING.getContent());
            }
        }
    }

    public static void displayNextLine() {
        System.out.println();
    }

    public static void displayGameProgress(HashMap<String, Integer> players) {
        for (String player : players.keySet()) {
            int currentPosition = players.get(player);
            String progress = generateProgress(currentPosition);
            System.out.println(player + DIVIDING_LINE.getContent() + progress);
        }
    }

    private static String generateProgress(int currentPosition) {
        StringBuilder result = new StringBuilder();
        for (int move = 0; move < currentPosition; move++) {
            result.append(MOVE_DISPLAY_STRING.getContent());
        }
        return result.toString();
    }
}
