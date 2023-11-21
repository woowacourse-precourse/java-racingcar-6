package racingcar.service;

import racingcar.model.TryCount;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class CreateTryCountService {

    private final InputView inputView;
    private final OutputView outputView;

    public CreateTryCountService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public TryCount createTryCount() {
        outputView.printOutTryCount();
        return new TryCount(inputView.inputTryCount());
    }
}
