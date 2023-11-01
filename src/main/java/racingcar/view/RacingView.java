package racingcar.view;

import static racingcar.constant.RacingMessage.getInputCarNameMessage;
import static racingcar.constant.RacingMessage.getInputTryCountMessage;
import static racingcar.constant.RacingMessage.getTryResultMessage;

import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.response.WinnerNames;

public class RacingView {

    private final InputView inputView;
    private final OutputMaker outputMaker;

    public RacingView(InputView inputView, OutputMaker outputMaker) {
        this.inputView = inputView;
        this.outputMaker = outputMaker;
    }

    public CarNames inputCarNames() {
        write(getInputCarNameMessage());
        return inputView.readCarNames();
    }

    public TryCount inputTryCount() {
        write(getInputTryCountMessage());
        return inputView.readTryCount();
    }

    public void startPrintTryResult() {
        write(getTryResultMessage());
    }

    public void showRacingStatus(RacingStatus racingStatus) {
        write(outputMaker.makeRacingStatusOutput(racingStatus));
    }

    public void showRacingWinner(WinnerNames winnerNames) {
        write(outputMaker.makeRacingWinnerOutput(winnerNames));
    }

    private void write(String message) {
        System.out.println(message);
    }
}
