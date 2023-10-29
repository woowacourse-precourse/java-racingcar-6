package racingcar.view;

public class OutputView {

    private static final String NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_INPUT_GUIDE = "시도할 회수는 몇회인가요?";

    public void printNamesGuide() {
        System.out.println(NAMES_INPUT_GUIDE);
    }

    public void printTrialGuide() {
        System.out.println(TRIAL_INPUT_GUIDE);
    }

}
