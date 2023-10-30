package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final OutputView outputView;

    public InputView() {
        outputView = new OutputView();
    }

    public String enterCarNames() {
        outputView.enterCarNamesMessage();
        return Console.readLine();
    }

    public String enterTryNumber() {
        outputView.enterTryNumberMessage();
        return Console.readLine();
    }
}
