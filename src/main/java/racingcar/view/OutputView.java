package racingcar.view;

public class OutputView {
    private final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void displayCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void displayTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void displayResultGuideMessage() {
    }

    public void displayLocation() {
    }

    public void displayWinner() {
    }
}
