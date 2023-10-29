package racingcar.controller;

import java.util.List;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.WinnerDTO;
import racingcar.view.OutputView;

public class Racing {
    private final Game game;
    private final Result result;

    public Racing(Game game, Result result) {
        this.game = game;
        this.result = result;
    }

    public void start() {
        List<AllRoundDTO> allRoundResults = playGame();
        WinnerDTO winnerDTO = announceResult();

        displayResults(allRoundResults, winnerDTO);
    }

    private List<AllRoundDTO> playGame() {
        return game.play();
    }

    private WinnerDTO announceResult() {
        return result.announce();
    }

    private void displayResults(List<AllRoundDTO> allRoundResults, WinnerDTO winnerResults) {
        OutputView.printAllRoundResults(allRoundResults);
        OutputView.printWinner(winnerResults);
    }
}
