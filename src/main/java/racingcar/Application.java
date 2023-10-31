package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        RacingGame racingGame = new RacingGame();
        RacingGameService racingGameService = new RacingGameService(racingGame);
        RacingGameController controller = new RacingGameController(view, racingGameService);

        controller.start();
    }
}
