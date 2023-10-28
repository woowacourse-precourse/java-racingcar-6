package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args){
        AppConfig appConfig = new AppConfig();
        RacingcarController racingcarController = appConfig.racingcarController();

        racingcarController.play();
    }
}
