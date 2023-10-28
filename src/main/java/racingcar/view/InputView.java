package racingcar.view;

public class InputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_QUESTION_MESSAGE = "시도할 회수는 몇회인가요?";

    public void showGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void showTrialNumberInputMessage() {
        System.out.println(TRIAL_QUESTION_MESSAGE);
    }
}
