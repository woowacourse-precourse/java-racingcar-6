package racingcar.view;

public class OutputView {

    private static final String PROMPT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void promptCarNames() {
        System.out.println(PROMPT_CAR_NAMES_MESSAGE);
    }
}
