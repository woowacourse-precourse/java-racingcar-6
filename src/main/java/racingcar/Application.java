package racingcar;

import racingcar.Controller.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController race = new RaceController();
        race.start();
    }
}
