package racingcar.view;

public class OutputView {
    private final static String moveUnit = "-";
    private final static String resultMessage = "실행 결과";
    private final static String printMoveFormat = "%s : %s\n";

    public static void printResult() {
        System.out.println(resultMessage);
    }

    public static void printMove(String carName, int moveDistance) {
        String moveUnits = moveUnit.repeat(moveDistance);
        System.out.printf(printMoveFormat, carName, moveUnits);
    }
}
