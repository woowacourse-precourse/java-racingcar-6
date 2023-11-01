package racingcar.view;

public class OutputView {
    public static final String PRINT_RESULT = "실행 결과";
    public static final String PRINT_COLON = " : ";
    public static final String PRINT_HYPHEN = "-";
    public static final String PRINT_WINNERS = "최종 우승자 : ";

    public static void printResult() {
        System.out.println(PRINT_RESULT);
    }

    public static void printColon() {
        System.out.print(PRINT_COLON);
    }

    public static void printHyphen() {
        System.out.print(PRINT_HYPHEN);
    }

    public static void printWinners() {
        System.out.print(PRINT_WINNERS);
    }
}
