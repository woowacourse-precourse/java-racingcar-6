package racingcar.controller;

import java.util.List;
import racingcar.common.type.TrialCount;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.WinnerDTO;
import racingcar.view.OutputView;

public class Racing {
    private final Game game;
    private final Result result;

    private Racing(Game game, Result result) {
        this.game = game;
        this.result = result;
    }

    public static Racing of(Game game, Result result) {
        return new Racing(game, result);
    }

    public void start(TrialCount trialCount) {
        List<AllRoundDTO> allRoundResults = playGame(trialCount);
        WinnerDTO winnerDTO = announceResult();

        displayResults(allRoundResults, winnerDTO);
    }

    private List<AllRoundDTO> playGame(TrialCount trialCount) {
        return game.play(trialCount);
    }

    private WinnerDTO announceResult() {
        return result.announce();
    }

    private void displayResults(List<AllRoundDTO> allRoundResults, WinnerDTO winnerResults) {
        OutputView.printAllRoundResults(allRoundResults);
        OutputView.printWinner(winnerResults);
    }
}
