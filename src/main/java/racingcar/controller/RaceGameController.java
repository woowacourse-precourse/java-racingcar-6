package racingcar.controller;

import racingcar.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameController {

    InputView input = new InputView();
    List<Car> carList = new ArrayList<>();

    public void newGame(){
        String[] cars = input.getCarNames();

        for(String car : cars){
            Car newCar = new Car(car);
            carList.add(newCar);
        }

    }




}
