package racingcar;

import racingcar.controller.CarController;

public class User {

    private final CarController carController = new CarController();

    public void play() {
        save();
        race();
    }

    public void save() {
        carController.save();
    }

    public void race() {
        int raceCount = carController.getRaceCount();
        int round = 1;
        while (round <= raceCount) {
            carController.forward();
            round++;
        }
    }

}
