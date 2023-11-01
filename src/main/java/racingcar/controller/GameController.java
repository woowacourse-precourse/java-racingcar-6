package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.dto.GameResult;
import racingcar.resolver.InputResolver;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService;
    private final OutputView outputView;
    private final InputResolver inputResolver;

    public GameController(GameService gameService, OutputView outputView, InputResolver inputResolver) {
        this.gameService = gameService;
        this.outputView = outputView;
        this.inputResolver = inputResolver;
    }

    public void game(){
        List<String> carNames = inputResolver.preprocessCarName();
        int count = inputResolver.preprocessCount();

        Game game = gameService.settingGame(carNames,count);

        outputView.outputResultString();
        racingGame(game);


    }

    private void racingGame(Game game) {
        for (int i = 0; i < game.getCount(); i++) {
            List<GameResult> gameResults = gameService.startGame(game);
            outputView.outputGameResult(gameResults);
        }
    }
}
