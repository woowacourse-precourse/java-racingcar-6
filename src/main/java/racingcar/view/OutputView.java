package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    private static final String DASH = "-";
    private static final String PLAY_RESULT = "\n실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void printBlankLine() {
        System.out.println();
    }
    public static void printResult() {
        System.out.println(PLAY_RESULT);
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.print(FINAL_WINNER);
        System.out.println(String.join(", ", winners));
    }

    public static void printMove(int distance, String name) {
        System.out.println(name + " : " + formatDistance(distance));
    }

    public static String formatDistance(int distance){
        return DASH.repeat(distance);
    }
}
