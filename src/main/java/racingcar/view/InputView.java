package racingcar.view;

public class InputView {

    private static final String  CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT = "시도할 회수는 몇회인가요?";

    public void printCarNameMessage() {
        System.out.println(CAR_NAME_INPUT);
    }

    public void printTimesInputMessage() {
        System.out.println(RACE_COUNT);
    }

}
