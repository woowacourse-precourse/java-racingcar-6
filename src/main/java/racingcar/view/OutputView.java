package racingcar.view;

public class OutputView {
    private static final String INPUT_RACING_CAR_MESSAGE= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";

    public static void printCarNameInputMessage() {
        System.out.println(INPUT_RACING_CAR_MESSAGE);
    }

    public static void printRacingCountInputMessage() {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
    }

    public static void printRacingResultMessage() {
        System.out.println();
        System.out.println(RACING_RESULT_MESSAGE);
    }
}
