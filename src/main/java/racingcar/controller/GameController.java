package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.dto.GameResult;
import racingcar.service.GameService;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService;
    private final OutputView outputView;

    public GameController(GameService gameService, OutputView outputView) {
        this.gameService = gameService;
        this.outputView = outputView;
    }

    public void Game(){
        Game game = gameService.settingGame();

        outputView.outputResultString();

        List<GameResult> gameResults = gameService.startGame(game);
        outputView.outputGameResult(gameResults);

    }
}
