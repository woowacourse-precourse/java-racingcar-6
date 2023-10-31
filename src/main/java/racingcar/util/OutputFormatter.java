package racingcar.util;

import java.util.List;
import java.util.Map;

public class OutputFormatter {
    private static final String QUERY_FOR_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUERY_FOR_NUM_OF_TRIES_INPUT = "시도할 회수는 몇회인가요?";
    private static final String INDICATION_TO_START_TO_SHOW_RESULTS = "실행 결과";
    private static final String SINGLE_STATE_REPRESENTATION = "-";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String WINNERS_SEPARATOR = ", ";

    public static String getMessageWhenInputCarNames() {
        return QUERY_FOR_CAR_NAMES_INPUT;
    }

    public static String getMessageWhenInputNumOfTries() {
        return QUERY_FOR_NUM_OF_TRIES_INPUT;
    }

    public static String getMessageToIndicateToStartToShowResult() {
        return INDICATION_TO_START_TO_SHOW_RESULTS;
    }

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

    public static String getMessageForWinners(List<String> winners) {
        String winnersInString = String.join(WINNERS_SEPARATOR, winners);
        return FINAL_WINNER + winnersInString;
    }
}
