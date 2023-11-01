package racingcar.view;

import java.util.List;
import racingcar.dto.RacingGameResult;
import racingcar.dto.WinnerNames;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<String> insertCarNames() {
        outputView.requestCarNames(inputView.getDelimiterDescription(), inputView.getDelimiter());
        return inputView.enterCarNames();
    }

    public int insertRaceCount() {
        outputView.requestRaceCount();
        return inputView.enterRaceCount();
    }

    public void showRacingGameResult(RacingGameResult racingGameResult) {
        outputView.printRacingGameResult(racingGameResult);
    }
}
