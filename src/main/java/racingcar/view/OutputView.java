package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String PROCESS_PRINT_START = "실행 결과";
    private static final String PROCESS_BAR = "-";
    private static final String WINNER_SENTENCE = "최종 우승자 : ";
    private static final String COMMA = ", ";


    public static void processPrintStartMessage() {
        System.out.println(PROCESS_PRINT_START);
    }


    public static void currentProcessPrint() {

    }


    public static void printWinner(List<String> winners) {
        StringBuilder message = new StringBuilder();

        message.append(WINNER_SENTENCE);
        winners.stream().forEach(name -> message.append(name).append(COMMA));
        message.delete(message.length()-2, message.length()-1);

        System.out.println(message);
    }

}
