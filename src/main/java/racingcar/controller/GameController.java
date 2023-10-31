package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.view.PrintView;

public class GameController {
    private Game game = new Game();

    private final InputController inputController = new InputController(game);
    private final StageController stageController = new StageController(game);
    private final GameService gameService = new GameService();

    public void runGame() {
        inputController.inputCarNames();
        int stageTimes = inputController.inputStageTimes();
        for (int i = 1; i <= stageTimes; i++) {
            stageController.runStage();
            stageController.returnStageResult();
        }
        returnWinners();
    }

    public void returnWinners() {
        ArrayList<String> winners = gameService.checkWinners(game.getCars());
        PrintView.winnerResultMessage(winners);
    }
}
