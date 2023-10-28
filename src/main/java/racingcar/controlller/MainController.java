package racingcar.controlller;

public class MainController {
    RacingGameController racingGameController;

    private void init() {
        racingGameController = new RacingGameController(true);
    }

    public void start() {
        init();
        racingGameController.run();
    }
}
