package racingcar.mock;

import java.util.List;
import racingcar.game.RacingGameScreen;
import racingcar.game.vo.RacerPosition;
import racingcar.game.vo.RacingCarNamesInput;
import racingcar.game.vo.TotalTurnInput;
import racingcar.io.reader.Reader;
import racingcar.io.writer.Writer;

public class MockRacingGameScreen extends RacingGameScreen {
    private String racingCarNames;
    private String totalTurn;
    private List<String> winnerNames;

    public MockRacingGameScreen(Reader reader, Writer writer) {
        super(reader, writer);
    }

    @Override
    public RacingCarNamesInput inputRacingCarNames() {
        return new RacingCarNamesInput(racingCarNames);
    }

    @Override
    public TotalTurnInput inputTotalTurn() {
        return new TotalTurnInput(totalTurn);
    }

    @Override
    public void startShowGameResult() {
    }

    @Override
    public void showTurnResult(List<RacerPosition> turnResult) {
    }

    @Override
    public void showError(String message) {
    }

    @Override
    public void showFinalWinner(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    @Override
    public void close() {
    }

    public void setRacingCarNames(String racingCarNames) {
        this.racingCarNames = racingCarNames;
    }

    public void setTotalTurn(String totalTurn) {
        this.totalTurn = totalTurn;
    }

    public List<String> getWinnerNames() {
        return this.winnerNames;
    }
}