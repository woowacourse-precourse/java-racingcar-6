package racingcar.view;

public class InputView {

    private static final String MESSAGE_OF_REQUEST_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void requestNames() {
        System.out.println(MESSAGE_OF_REQUEST_NAMES);
    }

}
