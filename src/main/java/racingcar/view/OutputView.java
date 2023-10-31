package racingcar.view;

import racingcar.domain.Cars;

public final class OutputView {
    private static final String CAR_NAMES_INPUT_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TOTAL_ROUND_INPUT_QUESTION = "시도할 횟수는 몇회인가요?";
    private static final String GAME_RESULT_PREFIX_MESSAGE = "실행 결과";
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private static final String MOVE_VALUE = "-";
    private static final String WINNER_NAMES_MESSAGE_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_NAMES_RESULT_SEPARATOR = ", ";

    private OutputView() {}

    public static void printCarNameInputQuestion() {
        System.out.println(CAR_NAMES_INPUT_QUESTION);
    }

    public static void printTotalRoundInputQuestion() {
        System.out.println(TOTAL_ROUND_INPUT_QUESTION);
    }

    public static void printGameStartMessage() {
        System.out.println();
        System.out.println(GAME_RESULT_PREFIX_MESSAGE);
    }

    public static void printCurrentRaceResult(final Cars cars) {
        for (int i = 0; i < cars.getSize(); i++) {
            final String name = cars.getNameFromIndex(i);
            final String currentDistanceValue = getCurrentDistanceValue(cars, i);
            System.out.println(String.format(GAME_RESULT_FORMAT, name, currentDistanceValue));
        }
        System.out.println();
    }

    private static String getCurrentDistanceValue(final Cars cars, final int index) {
        final int distance = cars.getDistanceFromIndex(index);
        return MOVE_VALUE.repeat(distance);
    }

    public static void printWinnerNames(final Cars cars) {
        final String winnerNames = String.join(WINNER_NAMES_RESULT_SEPARATOR, cars.getWinnerNames());
        System.out.println(String.format(WINNER_NAMES_MESSAGE_FORMAT, winnerNames));
    }
}
