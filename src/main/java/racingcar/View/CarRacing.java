package racingcar.View;

import racingcar.Controller.InputController;
import racingcar.Controller.RaceController;

public class CarRacing {
    public void run(){
        InputController inputController = new InputController();
        RaceController raceController = new RaceController();

        inputController.getNameOfCar();
        int raceTries=inputController.getRaceTries();

        for (int i=0;i<raceTries;i++){
            raceController.raceStart();
        }
    }
}