package racingcar.view;

public class OutputView {
    private final static String resultMessage = "\n실행 결과";
    private final static String printFinalWinnersFormat = "최종 우승자 : %s";

    public static void printResultMessage() {
        System.out.println(resultMessage);
    }

    public static void printMove(String resultMap) {
        System.out.println(resultMap);
    }

    public static void printFinalWinners(String finalWinners) {
        System.out.printf(printFinalWinnersFormat, finalWinners);
    }
}
