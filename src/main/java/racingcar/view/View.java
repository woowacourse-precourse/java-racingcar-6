package racingcar.view;

import racingcar.util.InputValidator;

public interface View {
    static InputView generateInputView(final InputValidator inputValidator) {
        return new InputView(inputValidator);
    }
    static OutputView generateOutputView() {
        return new OutputView();
    }
}
