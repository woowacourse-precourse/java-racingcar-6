package racingcar.view;

public class RacingCarView {

    public static final String CARS_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "실행 결과";

    private static RacingCarView instance;

    private RacingCarView() {
    }

    public static RacingCarView getInstance() {
        if (instance == null) {
            instance = new RacingCarView();
        }

        return instance;
    }

    public void printInputCarNameMessage() {
        System.out.println(CARS_NAME_PROMPT);
    }

    public void printInputTryCountMessage() {
        System.out.println(TRY_COUNT_PROMPT);
    }
}
