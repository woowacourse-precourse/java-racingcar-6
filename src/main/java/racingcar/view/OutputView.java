package racingcar.view;

public class OutputView {

    private static final String RACE_START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printRaceStart() {
        System.out.println(RACE_START_MESSAGE);
    }

    public static void printTryCount() {
        System.out.println(TRY_COUNT_MESSAGE);
    }

    public static void printWinners(String winners) {
        System.out.println(FINAL_WINNER_MESSAGE + winners);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void newLine() {
        System.out.println();
    }
}