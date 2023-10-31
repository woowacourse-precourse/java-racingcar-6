package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Game;
import racingcar.service.StageService;
import racingcar.view.PrintView;

public class StageController {
    private Game game;

    public StageController(Game game) {
        this.game = game;
    }

    private final StageService stageService = new StageService();

    public void runStage() {
        for (String car : game.getCars().keySet()) {
            if (stageService.stageProcess()) {
                game.moveForward(car);
            }
        }
    }

    public void returnStageResult() {
        ArrayList<String> list = stageService.checkStageResult(game.getCars());
        PrintView.stageResultMessage(list);
    }

    public void initialStageResult() {
        PrintView.initialStageResultMessage();
    }
}
