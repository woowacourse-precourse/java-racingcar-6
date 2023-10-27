package racingcar.View;

import racingcar.Controller.InputController;
import racingcar.Controller.RaceController;

import java.util.List;

public class CarRacing {
    public void run(){
        InputController inputController = new InputController();
        RaceController raceController = new RaceController();

        inputController.getNameOfCar();
        int raceTries=inputController.getRaceTries();

        System.out.println("실행 결과");
        for (int i=0;i<raceTries;i++){
            raceController.raceStart();
        }
        List<String> winners=raceController.getWinner();
    }
}