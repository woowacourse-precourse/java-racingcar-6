package racingcar.view;

public class OutputView {
    private final static String resultMessage = "\n실행 결과";

    public static void printResultMessage() {
        System.out.println(resultMessage);
    }

    public static void printMove(String resultMap) {
        System.out.println(resultMap);
    }

    public static void printFinalWinners(String finalWinners) {
        System.out.printf(finalWinners);
    }
}
