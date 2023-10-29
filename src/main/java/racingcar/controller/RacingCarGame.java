package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public void runGame(){
        List<String> carNameList = InputView.inputCarName();

        int countNumber = InputView.inputCount();

        List<Car> carList = new ArrayList<>();
        for (String name : carNameList){
            carList.add(new Car(name));
        }

    }
}
