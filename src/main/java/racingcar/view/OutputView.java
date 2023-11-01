package racingcar.view;


import java.util.StringJoiner;
import java.util.stream.Collectors;
import racingcar.constant.GameMessage;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;
import racingcar.model.RacingCarResult;

import static racingcar.constant.GameMessage.*;
public class OutputView {
    private static final String SEPARATE_CHAR = ", ";
    private static final String SEPARATE_COLON = " : ";
    private static final String GAME_RESULT_MESSAGE = GameMessage.GAME_RESULT_MESSAGE.getValue();
    private static final String GAME_WINNER_MESSAGE = GameMessage.GAME_WINNER_MESSAGE.getValue();
    public static void gameResultMessge() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void moveDistanceMessage(RacingCar racingCar) {
        System.out.println(racingCar.getName() + SEPARATE_COLON + racingCar.getDistanceAsBar());
    }

    public static void printFinalWinner(RacingCarList winners) {
        String result = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(SEPARATE_CHAR));

        System.out.println(GAME_WINNER_MESSAGE+SEPARATE_COLON+result);
    }

    public static void newLine() {
        System.out.println();
    }
}
