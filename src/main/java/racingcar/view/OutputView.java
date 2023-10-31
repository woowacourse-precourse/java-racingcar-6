package racingcar.view;

import java.util.stream.IntStream;
import static racingcar.view.constants.OutputMessage.*;
import static racingcar.view.constants.IntegerViewConstants.*;

public class OutputView {
    public static void startGame(){
        System.out.println(START_MESSAGE.getMessage());
    }

    public static void askGameRounds() {
        System.out.println(ASK_GAME_ROUNDS.getMessage());
    }

    public static void startGameResult(){
        System.out.println(GAME_RESULT.getMessage());
    }

    public static void broadcastCarRoundScore(String carName, Integer score) {
        System.out.printf("%s %s ", carName, DISPLAY_USER_SCORE_SIGN.getMessage());
        IntStream.range(STARTING_POINT.getValue(), score)
                .forEach(OutputView::getScoreSign);
        System.out.println();
    }

    private static void getScoreSign(int x) {
        System.out.printf("%s", SCORE_SIGN.getMessage());
    }

    public static void theEndOfRound(){
        System.out.println();
    }

    public static void finalGameResult(String cars){
        System.out.printf("%s %s",FINAL_WINNER.getMessage(), cars);
    }
}
