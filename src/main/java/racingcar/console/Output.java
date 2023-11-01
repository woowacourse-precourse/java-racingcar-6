package racingcar.console;

public class Output {
    private static final String CAR_STATE_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";

    public static void printCarState(String name, int position) {
        System.out.println(String.format(CAR_STATE_FORMAT, name, "-".repeat(position)));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(String winners) {
        System.out.println(String.format(WINNER_MESSAGE, winners));
    }
}
