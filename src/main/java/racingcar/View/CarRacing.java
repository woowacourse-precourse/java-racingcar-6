package racingcar.View;

import racingcar.Controller.InputController;
import racingcar.Controller.RaceController;

import java.util.List;

public class CarRacing {
    public void run(){
        InputController inputController = new InputController();
        RaceController raceController = new RaceController();
        int raceTries=0;
        try {
            inputController.getNameOfCar();
            raceTries = inputController.getRaceTries();
        }catch(Exception e){
            throw new IllegalStateException();
        }


        System.out.println("실행 결과");
        for (int i=0;i<raceTries;i++){
            raceController.raceStart();
        }
        List<String> winners=raceController.getWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}