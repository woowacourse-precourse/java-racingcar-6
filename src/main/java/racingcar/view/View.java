package racingcar.view;

import java.util.List;
import racingcar.dto.RacingGameStatus;
import racingcar.dto.WinnerNames;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<String> getCarNames() {
        outputView.requestCarNames(inputView.getDelimiterDescription(), inputView.getDelimiter());
        return inputView.enterCarNames();
    }

    public int getRaceCount() {
        outputView.requestRaceCount();
        return inputView.enterRaceCount();
    }

    public void showRacingGameStatus(RacingGameStatus racingGameStatus) {
        outputView.printRacingGameStatus(racingGameStatus);
    }

    public void showWinnerNames(WinnerNames winnerNames) {
        outputView.printWinnerNames(winnerNames);
    }
}
