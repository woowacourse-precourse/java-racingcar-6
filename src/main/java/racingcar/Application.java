package racingcar;

import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController controller = new RaceController();
        controller.startRace();
    }
}
