package racingcar.view;

import racingcar.dto.CarNames;
import racingcar.dto.RacingStatus;
import racingcar.dto.TryCount;
import racingcar.model.Racing;

public class RacingView {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public CarNames inputCarNames() {
        outputView.writeInputCarNameMessage();
        return inputView.readCarNames();
    }

    public TryCount inputTryCount() {
        outputView.writeInputTryCountMessage();
        return inputView.readTryCount();
    }

    public void startPrintTryResult() {
        outputView.writeTryResultMessage();
    }

    public void showRacingStatus(RacingStatus racingStatus) {
        outputView.writeRacingStatus(racingStatus);
    }

    public void showRacingWinner(Racing racing) {
        outputView.writeRacingWinner(racing);
    }
}
