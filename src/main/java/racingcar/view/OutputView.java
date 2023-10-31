package racingcar.view;

import racingcar.game.Car;
import static racingcar.view.constants.OutputMessage.*;

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

    public static void broadcastCarRoundScore(Car car) {
        // TODO: getter 없이 쓸 수 있는 방법 고민 해보기
        System.out.printf("%s %s ", car.getCarName(), DISPLAY_USER_SCORE_SIGN.getMessage());
        for(int i=0; i<car.getScore(); i++){
            System.out.printf("%s", SCORE_SIGN.getMessage());
        }
        System.out.println();
    }

    public static void theEndOfRound(){
        System.out.println();
    }

    public static void finalGameResult(String cars){
        System.out.printf("%s %s",FINAL_WINNER.getMessage(), cars);
    }
}
