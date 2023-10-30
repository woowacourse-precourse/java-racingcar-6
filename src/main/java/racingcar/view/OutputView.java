package racingcar.view;

import racingcar.domain.Cars;

import static racingcar.config.GameConfig.MOVE_VALUE;
import static racingcar.view.message.GameMessage.CAR_NAME_INPUT_QUESTION_MESSAGE;
import static racingcar.view.message.GameMessage.GAME_PROGRESS_RESULT_FORMAT;
import static racingcar.view.message.GameMessage.GAME_RESULT_PREFIX_MESSAGE;
import static racingcar.view.message.GameMessage.TOTAL_ROUND_INPUT_QUESTION_MESSAGE;

public final class OutputView {
    private OutputView() {

    }

    public static void printCarNameInputQuestion() {
        System.out.println(CAR_NAME_INPUT_QUESTION_MESSAGE);
    }

    public static void printTotalRoundInputQuestion() {
        System.out.println(TOTAL_ROUND_INPUT_QUESTION_MESSAGE);
    }

    public static void printGameStartMessage() {
        System.out.println();
        System.out.println(GAME_RESULT_PREFIX_MESSAGE);
    }

    public static void printCurrentProgress(final Cars cars) {
        for (int i = 0; i < cars.getSize(); i++) {
            final String name = cars.getNameFromIndex(i);
            final String currentDistanceValue = getCurrentDistanceValue(cars, i);
            System.out.println(String.format(GAME_PROGRESS_RESULT_FORMAT, name, currentDistanceValue));
        }
        System.out.println();
    }

    private static String getCurrentDistanceValue(final Cars cars, final int index) {
        final int distance = cars.getDistanceFromIndex(index);
        return MOVE_VALUE.repeat(distance);
    }
}
