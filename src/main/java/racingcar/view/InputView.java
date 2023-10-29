package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public String receiveRacingCarNamesInput() {
        outputView.printRacingCarInputMessage();
        return Console.readLine();
    }

    public String receiveTryCountInput() {
        outputView.printTryCountInputMessage();
        return Console.readLine();
    }
}
