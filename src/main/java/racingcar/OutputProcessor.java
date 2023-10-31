package racingcar;

import java.util.List;

public class OutputProcessor {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REPETITION_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    public static final String PROGRESS_MARK = "-";
    public static final String MOVE_RESULT_SEPARATOR = " : ";
    public static final String CAR_LIST_SEPARATOR = ", ";

    public void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printRepetitionInputMessage() {
        System.out.println(REPETITION_INPUT_MESSAGE);
    }

    public void printMoveResult(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + MOVE_RESULT_SEPARATOR + PROGRESS_MARK.repeat(player.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Player> winners) {
        System.out.println(WINNER_MESSAGE_PREFIX + formatCarList(winners));
    }

    private String formatCarList(List<Player> winners) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < winners.size(); index++) {
            result.append(winners.get(index).getName());
            if (!isLastIndex(winners, index)) {
                result.append(CAR_LIST_SEPARATOR);
            }
        }

        return result.toString();
    }

    private static boolean isLastIndex(List<Player> winners, int index) {
        return index == winners.size() - 1;
    }
}
