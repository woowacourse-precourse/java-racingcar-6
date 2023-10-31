package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;

public class Application {
    public static void main(String[] args) {

        RaceController raceController=new RaceController();
        raceController.startGame();

    }
}
