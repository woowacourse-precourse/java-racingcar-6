package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.CarName;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> carList = new ArrayList<>();
    OutputView outputView = new OutputView();
    CarName carName = new CarName();
    public void play() {
        outputView.racingStart();
        String[] carNames = carName.input().split(",");
        init(carNames);
        outputView.rotateCount();
    }

    private void init(String[] carNames){
        for(int index=0; index<carNames.length; index++){
            Car car = new Car(carNames[index],"");
            carList.add(car);
        }
    }
}
