package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.User;

public class Application {

    public static void main(String[] args) {
        User user = new User();

        RaceController raceController = new RaceController(user);
        raceController.run();


    }

}
