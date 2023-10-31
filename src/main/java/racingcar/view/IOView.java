package racingcar.view;

import java.util.List;
import racingcar.dto.RacingGameStatus;
import racingcar.dto.WinnerNames;

public class IOView implements View {
    private final InputView inputView;
    private final OutputView outputView;

    public IOView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public List<String> getCarNames() {
        outputView.requestCarNames(inputView.getDelimiterDescription(), inputView.getDelimiter());
        return inputView.enterCarNames();
    }

    @Override
    public int getRaceCount() {
        outputView.requestRaceCount();
        return inputView.enterRaceCount();
    }

    @Override
    public void showRacingGameStatus(RacingGameStatus racingGameStatus) {
        outputView.printRacingGameStatus(racingGameStatus);
    }

    @Override
    public void showWinnerNames(WinnerNames winnerNames) {
        outputView.printWinnerNames(winnerNames);
    }
}
