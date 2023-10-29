package racingcar.view;

import racingcar.global.GameStrConstant;
import racingcar.vo.Car;

import java.util.List;

import static racingcar.global.GameStrConstant.*;
import static racingcar.view.ConstantView.*;

public class OutputView {
    public static void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAMES.getMessage());
    }

    public static void printInputTriesCountMessage() {
        System.out.println(INPUT_TRIES_COUNT.getMessage());
    }

    public static void printResultMessage() {
        System.out.println(RESULT.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMovements(Car car) {
        System.out.println(buildMovementString(car));
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(buildWinnersString(winners));
    }

    private static String buildMovementString(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(GAME_RESULT_SEPARATOR.getValue());
        for (int moveIndex = 0; moveIndex < car.getCompletedMoves(); moveIndex++) {
            if (car.getMovementFlags().get(moveIndex)) {
                sb.append(CAR_MOVEMENT.getValue());
            }
        }
        return sb.toString();
    }

    private static String buildWinnersString(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER.getMessage()).append(GAME_RESULT_SEPARATOR.getValue());
        int i;
        for (i = 0; i < winners.size() - 1; i++) {
            sb.append(winners.get(i).getName());
            sb.append(CAR_NAME_SEPARATOR.getValue()).append(WHITE_SPACE.getValue());
        }
        sb.append(winners.get(i).getName());
        return sb.toString();
    }
}
