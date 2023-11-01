package racingcar.view;

public class OutputView {
    private static final String ONE_STEP = "-";

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printLoopSetMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

}
