package racingcar.view;

import java.util.List;
import racingcar.domain.RaceCar;

public class OutputView {
    private static final int END_INDEX_OFFSET = 2;
    private static final String COMMA_SPACE = ", ";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";
    private static final String ROUND_RESULT = "실행 결과";

    public static void printResult(List<RaceCar> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        winners.forEach(winner -> stringBuilder.append(winner.getName()).append(COMMA_SPACE));
        stringBuilder.delete(stringBuilder.length() - END_INDEX_OFFSET, stringBuilder.length());
        System.out.println(WINNER_ANNOUNCEMENT + stringBuilder);
    }

    public static void printCurrentRaceStatus(List<RaceCar> raceCars) {
        raceCars.forEach(OutputView::printCurrentCarStatus);
        System.out.println();
    }

    private static void printCurrentCarStatus(RaceCar raceCar) {
        System.out.println(raceCar.currentStatus());
    }

    public static void printRaceStartMessage() {
        System.out.println(ROUND_RESULT);
    }
}
