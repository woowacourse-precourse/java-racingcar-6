package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private final static String moveUnit = "-";
    private final static String resultMessage = "\n실행 결과";
    private final static String printMoveFormat = "%s : %s\n";
    private final static String printFinalWinnersFormat = "최종 우승자 : %s";

    public static void printResult() {
        System.out.println(resultMessage);
    }

    public static void printMove(Map<String, Integer> resultMap) {
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            String carName = entry.getKey();
            int moveDistance = entry.getValue();
            String moveUnits = moveUnit.repeat(moveDistance);
            System.out.printf(printMoveFormat, carName, moveUnits);
        }
        System.out.println();
    }

    public static void printFinalWinners(List<String> finalWinnersList) {
        StringJoiner finalWinnersJoiner = new StringJoiner(", ");
        for (String winner : finalWinnersList) {
            finalWinnersJoiner.add(winner);
        }
        System.out.printf(printFinalWinnersFormat, finalWinnersJoiner);
    }
}
