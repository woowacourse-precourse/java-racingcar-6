package racingcar.view;

public class InputView {

    private static String nameView = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String countView = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static String nameInputView() {
        return nameView;
    }

    public static String countInputView() {
        return countView;
    }

}
