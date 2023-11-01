package racingcar.view;
import racingcar.constants.AppConstants;

public class GameOutput {

    public static void printInputCarName() {
        System.out.println(AppConstants.MSG_INPUT_CAR_NAME);
    }

    public static void printInputGameRound() {
        System.out.println(AppConstants.MSG_INPUT_GAME_ROUND);
    }
    public static void printRoundResult(String str) {
        System.out.println(str);
    }
    public static void printGameStart() {
        System.out.println(AppConstants.MSG_GAME_START);
    }
    public static void printErrorMessage(String str) {
        System.out.println(str);
    }
    public static void printFinalWinner(String str) {
        System.out.println(str);
    }
}
