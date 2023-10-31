package racingcar.util.io;

public class OutputUtils {
    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVE = "%s : %s";
    private static final String MOVE = "-";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : %s";

    public static void printCarInputMessage() {
        System.out.println(CAR_INPUT_MESSAGE);
    }

    public static void printMoveInputMessage() {
        System.out.println(MOVE_INPUT_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printCarMove(String name, int move) {
        System.out.println(String.format(CAR_MOVE, name, MOVE.repeat(move)));
    }

    public static void printFinalWinners(String winners) {
        System.out.println(String.format(FINAL_WINNER_MESSAGE, winners));
    }
}
