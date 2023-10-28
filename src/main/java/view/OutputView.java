package view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinnerMessage() {
        System.out.print(WINNER_MESSAGE);
    }

}
