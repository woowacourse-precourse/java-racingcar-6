package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final static String moveUnit = "-";
    private final static String resultMessage = "실행 결과";
    private final static String printMoveFormat = "%s : %s\n";
    private final static String printFinalWinnersFormat = "최종 우승자 : %s";

    public static void printResult() {
        System.out.println(resultMessage);
    }

    public static void printMove(String carName, int moveDistance) {
        String moveUnits = moveUnit.repeat(moveDistance);
        System.out.printf(printMoveFormat, carName, moveUnits);
    }

    public static void printFinalWinners(List<String> finalWinnersList){
        StringJoiner finalWinnersJoiner = new StringJoiner(", ");
        for (String winner : finalWinnersList) {
            finalWinnersJoiner.add(winner);
        }
        System.out.printf(printFinalWinnersFormat, finalWinnersJoiner.toString());
    }
}
