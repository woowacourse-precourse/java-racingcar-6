package racingcar;

import racingcar.controller.CarController;

public class User {

    private final CarController carController = new CarController();

    public void play() {
        save();
    }

    public void save() {
        carController.save();
    }

}
