package racingcar;
import racingcar.controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        RacingcarController racingcarController = appConfig.racingcarController();
        racingcarController.run();
    }
}
