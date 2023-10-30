package racingcar.view;

public class OutputView {
    private static final String RESULT_COMMAND = "\n실행 결과";
    private static final String COLON_SPACE = " : ";

    public static void printResultCommand() {
        System.out.println(RESULT_COMMAND);
    }

    public static void printRoundResult(String[] carNames, int[] distance) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + COLON_SPACE + generateHyphen(distance[i]));
        }
        System.out.println();
    }

    private static String generateHyphen(int count) {
        return "-".repeat(count);
    }
}
