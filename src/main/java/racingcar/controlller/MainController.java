package racingcar.controlller;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private List<GameController> gameControllerList;

    private void init() {
        gameControllerList = new ArrayList<>();
        gameControllerList.add(new RacingGameController(true));
    }

    public void start() {
        init();
        for (GameController gameController : gameControllerList) {
            if (gameController.isRunning) {
                gameController.run();
            }
        }
    }
}
