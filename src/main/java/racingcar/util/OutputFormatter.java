package racingcar.util;

import java.util.List;
import java.util.Map;

/**
 * A formatter, given a data object, generates a string in an appropriate format.
 */
public class OutputFormatter {
    private static final String QUERY_FOR_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUERY_FOR_NUM_OF_TRIES_INPUT = "시도할 회수는 몇회인가요?";
    private static final String INDICATION_TO_START_TO_SHOW_RESULTS = "실행 결과";
    private static final String SINGLE_STATE_REPRESENTATION = "-";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String WINNERS_SEPARATOR = ", ";

    /**
     * Gets a message to prompt the user to input names of cars.
     * @return a message to prompt the user to input names of cars.
     */
    public static String getMessageWhenInputCarNames() {
        return QUERY_FOR_CAR_NAMES_INPUT + "\n";
    }

    /**
     * Gets a message to prompt the user to input the number of repeats of the game.
     * @return a message to prompt the user.
     */
    public static String getMessageWhenInputNumOfTries() {
        return QUERY_FOR_NUM_OF_TRIES_INPUT + "\n";
    }

    /**
     * Gets a message to indicate that would show the result of each try from now.
     * @return a message.
     */
    public static String getMessageToIndicateToStartToShowResult() {
        return "\n" + INDICATION_TO_START_TO_SHOW_RESULTS + "\n";
    }

    /**
     * Given the names of cars and states of each car,
     * converts them into a string to show the current state of the game in each try.
     * @param cars the name of cars participating in the game. The sequence of cars should be the
     *             same as that of the input of the user.
     * @param states of each car in the current phase.
     * @return a string generated given the data.
     */
    public static String getMessageForEachStep(String[] cars, Map<String, Integer> states) {
        StringBuilder sb = new StringBuilder();
        for (String car : cars) {
            sb.append(car).append(" : ").append(convertIntoStateRepresentation(states.get(car))).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static String convertIntoStateRepresentation(int num) {
        return SINGLE_STATE_REPRESENTATION.repeat(Math.max(0, num));
    }

    /**
     * Given winners, generates a message to show who has won.
     * @param winners a list of winners. The sequence of winners should be the same as that of the input
     *                of the user.
     * @return a string generated given the data.
     */
    public static String getMessageForWinners(List<String> winners) {
        String winnersInString = String.join(WINNERS_SEPARATOR, winners);
        return FINAL_WINNER + winnersInString;
    }
}
