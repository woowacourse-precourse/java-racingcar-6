package racingcar.view;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void carNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public static void tryNumberInputMessage() {
        System.out.println(TRY_NUMBER_INPUT_MESSAGE);
    }

    public static void racingResultMessage(String message) {
        System.out.println(RACING_RESULT_MESSAGE);
        System.out.println(message);
    }

    public static void winnerMessage(String message) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(message);
    }
}
