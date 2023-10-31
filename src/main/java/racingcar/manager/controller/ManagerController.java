package racingcar.manager.controller;

import racingcar.car.controller.CarController;
import racingcar.user.controller.UserController;

public class ManagerController {



    public void run(){
        CarController carController = new CarController();
        UserController userController = new UserController();
    }
}
