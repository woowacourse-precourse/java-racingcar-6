package racingcar;

import racingcar.controller.Controller;
import racingcar.service.GamePlayingService;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        GamePlayingService gamePlayingService = new GamePlayingService();
        Controller controller = new Controller(view, gamePlayingService);

        controller.start();
    }
}
