package racingcar.view;

public class OutputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_RACING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_SEPARATOR = " : ";
    public static void printCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void printCarRacingCountMessage() {
        System.out.println(CAR_RACING_COUNT_MESSAGE);
    }

    public static void printCarRacingResult(String carName, int position) {
        String stringBuilder = carName
                + RESULT_SEPARATOR
                + "-".repeat(Math.max(0, position));
        System.out.println(stringBuilder);
    }
}
