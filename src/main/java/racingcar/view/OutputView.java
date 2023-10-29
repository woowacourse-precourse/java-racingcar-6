package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;

import static racingcar.constant.GameMessage.*;
public class OutputView {
    private static final String SEPARATE_CHAR = ", ";
    private static final String SEPARATE_COLON = " : ";

    public static void gameResultMessge() {
        System.out.println(GAME_RESULT_MESSAGE.getValue());
    }

    public static void moveDistanceMessage(RacingCar racingCar) {
        System.out.println(racingCar.getName() + SEPARATE_COLON + racingCar.getDistanceAsBar());
    }

    public static void printFinalWinner(List<String> winners) {
        String result = String.join(SEPARATE_CHAR, winners);
        System.out.println(GAME_WINNER_MESSAGE.getValue() + SEPARATE_COLON + result);
    }

    public static void newLine() {
        System.out.println();
    }
}
