package racingcar;

import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController race = new RaceController();
        race.hold();
    }
}
