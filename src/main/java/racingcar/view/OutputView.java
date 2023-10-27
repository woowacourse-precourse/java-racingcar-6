package racingcar.view;

public class OutputView {

    private static final String PROMPT_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PROMPT_INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String PROMPT_RUN_RESULT_TITLE = "실행 결과";
    private static final String PROMPT_FINAL_WINNER_TITLE = "최종 우승자 : ";

    public void displayInputCarNames() {
        System.out.println(PROMPT_INPUT_CAR_NAMES);
    }

    public void displayInputNumberOfAttempts() {
        System.out.println(PROMPT_INPUT_NUMBER_OF_ATTEMPTS);
    }

    public void displayRunResultTitle() {
        System.out.println(PROMPT_RUN_RESULT_TITLE);
    }

    public void displayRunResult(String result) {
        System.out.println(result);
        System.out.println();
    }

    public void displayFinalWinner(String winner) {
        System.out.print(PROMPT_FINAL_WINNER_TITLE);
        System.out.println(winner);
    }
}
