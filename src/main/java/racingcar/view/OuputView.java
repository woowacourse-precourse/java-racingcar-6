package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.GameResult;

public class OuputView {
    private static final String DISTANCE_FORMATTER = "-";

    public static void outputEmptyLine() {
        System.out.println();
    }

    public static void ouputBeforeGameResult() {
        System.out.println("\n실행결과");
    }

    public static void ouputGameResult(GameResult gameResult) {
        System.out.printf("%s : %s\n", gameResult.getName(), formDistance(gameResult.getPosition()));
    }

    public static void ouputGameWinner(List<String> winners) {
        System.out.print("최종 우승자 :");
        System.out.print(joinWinnersName(winners));
    }

    private static String joinWinnersName(List<String> winners) {
        return winners.stream().collect(Collectors.joining(",", " ", ""));
    }

    private static String formDistance(int distance) {
        return DISTANCE_FORMATTER.repeat(distance);
    }
}
