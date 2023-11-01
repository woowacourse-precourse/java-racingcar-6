package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;

public class RaceController {
    public void hold(){
        raceRegist();
        raceStart();
        raceEnd();
    }

    public void raceRegist(){
        List<Car> cars = InputView.registCarName();
        int carMoveNum = InputView.registCarMoveNum();
    }

    public void raceStart(){

    }

    public void raceEnd(){

    }
}
