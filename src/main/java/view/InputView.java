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

    public int enterTryNumber(){
        outputView.enterTryNumberMessage();
        String tryNumber = Console.readLine();
        return Integer.parseInt(tryNumber);
    }
}
