package view;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "최종 우승자 : ";
    private static final String STANDARD_DELIMITER = ", ";

    public static void printResult(List<String> winner) {
        System.out.print(RESULT_MESSAGE);
        System.out.print(String.join(STANDARD_DELIMITER, winner));
    }
}
