package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String SEPARATOR = " : ";
    private static final String PROGRESS_CHARACTER = "-";
    private static final String DELIMITER = ", ";

    public static void startPrintResultMessage() {
        printLine();
        System.out.println("실행 결과");
    }

    public static void printProgress(String name, int position) {
        System.out.println(name + SEPARATOR + PROGRESS_CHARACTER.repeat(position));
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(DELIMITER, winners));
    }

}
