package racingcar.controller;

import java.util.List;
import racingcar.model.GameService;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public RacingController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void playGame() {
        List<String> carNames = inputView.getCarNames();
        Integer roundCount = inputView.getRoundCount();

        gameService.initializeGame(carNames, roundCount);

        while (!gameService.isGameOver()) {
            RoundResult roundResult = gameService.executeRound();
            outputView.printRoundResult(roundResult);
        }

        Winners winners = gameService.findWinners();
        outputView.printWinner(winners);
    }
}
