package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.CarName;
import racingcar.view.Order;
import racingcar.view.RotatingCount;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> carList = new ArrayList<>();
    Order order = new Order();
    RotatingCount rotatingCount = new RotatingCount();
    CarName carName = new CarName();
    public void play() {
        order.racingStart();
        String[] carNames = carName.input().split(",");
        init(carNames);
        order.rotateCount();
        int RacingCount = rotatingCount.input();

    }

    private void init(String[] carNames){
        for(int index=0; index<carNames.length; index++){
            Car car = new Car(carNames[index],"");
            carList.add(car);
        }
    }
}
