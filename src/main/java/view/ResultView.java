package view;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "최종 우승자 : ";

    public static void printResult(List<String> winner) {
        System.out.print(RESULT_MESSAGE);
        System.out.println(String.join(", ", winner));
    }
}
