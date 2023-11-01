package racingcar.view;

import racingcar.dto.request.CarNames;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.request.TryCount;
import racingcar.model.Racing;

public class RacingView {

    private final InputView inputView;
    private final OutputMaker outputMaker;

    public RacingView(InputView inputView, OutputMaker outputMaker) {
        this.inputView = inputView;
        this.outputMaker = outputMaker;
    }

    public CarNames inputCarNames() {
        outputMaker.writeInputCarNameMessage();
        return inputView.readCarNames();
    }

    public TryCount inputTryCount() {
        outputMaker.writeInputTryCountMessage();
        return inputView.readTryCount();
    }

    public void startPrintTryResult() {
        outputMaker.writeTryResultMessage();
    }

    public void showRacingStatus(RacingStatus racingStatus) {
        outputMaker.writeRacingStatus(racingStatus);
    }

    public void showRacingWinner(Racing racing) {
        outputMaker.writeRacingWinner(racing);
    }
}
