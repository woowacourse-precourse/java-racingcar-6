package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String PROCESS_PRINT_START_SENTENCE = "실행 결과";
    private static final String WINNER_PRINT_START_SENTENCE = "최종 우승자 : ";
    private static final String PROCESS_BAR = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";


    public static void processPrintStartMessage() {
        printEmptyLine();
        System.out.println(PROCESS_PRINT_START_SENTENCE);
    }


    public static void printCarName(String name) {
        System.out.print(name + COLON);
    }

    public static void printCarLocation(int location) {
        System.out.println(PROCESS_BAR.repeat(location));
    }

    public static void printEmptyLine() {
        System.out.println();
    }


    public static void printWinner(List<String> winners) {
        StringBuilder message = new StringBuilder();

        message.append(WINNER_PRINT_START_SENTENCE);
        winners.stream().forEach(name -> message.append(name).append(COMMA));
        message.delete(message.length() - 2, message.length() - 1);

        System.out.println(message);
    }

}
