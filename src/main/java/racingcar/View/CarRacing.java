package racingcar.View;

import racingcar.Controller.InputController;

public class CarRacing {
    public void run(){
        InputController inputController = new InputController();
        inputController.getNameOfCar();
        int raceTries=inputController.getRaceTries();
    }
}