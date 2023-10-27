package racingcar.view;

public interface View {
    static InputView generateInputView() {
        return new InputView();
    }
    static OutputView generateOutputView() {
        return new OutputView();
    }
}
