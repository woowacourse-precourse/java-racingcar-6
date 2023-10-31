package racingcar.view;

import racingcar.domain.Cars;

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

    public static void printCurrentRaceResult(final Cars cars) {
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

    public static void printWinnerNames(final Cars cars) {
        final String winnerNames = String.join(WINNER_NAMES_RESULT_SEPARATOR, cars.getWinnerNames());
        System.out.println(String.format(WINNER_NAME_MESSAGE_FORMAT, winnerNames));
    }
}
