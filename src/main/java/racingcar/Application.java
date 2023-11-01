package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;
import racingcar.model.Cars;

public class Application {
    public static void main(String[] args) {
        
    	Cars cars = new Cars();
        RacingController racingController = new RacingController(cars);
        racingController.init();
        racingController.play();
        racingController.finish();
    }
}
