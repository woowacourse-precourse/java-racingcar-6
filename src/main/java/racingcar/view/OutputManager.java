package racingcar.view;

public class OutputManager {
    public static final String EXECUTE_MESSAGE = "실행 결과";

    public static void printGameStart() {
        System.out.println(EXECUTE_MESSAGE);
    }

    public static void printEachCycleResult(String name, Integer position) {
        System.out.println(String.format("%s : %s", name, "-".repeat(position)));
    }

    public static void printWinner(String winnerName) {
        System.out.println(String.format("최종 우승자 : %s", winnerName));
    }
}
