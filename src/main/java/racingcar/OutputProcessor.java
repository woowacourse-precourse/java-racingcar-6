package racingcar;

import java.util.List;

public class OutputProcessor {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REPETITION_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printRepetitionInputMessage() {
        System.out.println(REPETITION_INPUT_MESSAGE);
    }

    public void printMoveResult(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + " : " + "-".repeat(player.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Player> winners) {
        System.out.println("최종 우승자 : " + formatCarList(winners));
    }

    private String formatCarList(List<Player> winners) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < winners.size(); index++) {
            result.append(winners.get(index).getName());
            if (!isLastIndex(winners, index)) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    private static boolean isLastIndex(List<Player> winners, int index) {
        return index == winners.size() - 1;
    }
}
