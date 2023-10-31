package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.view.OutputView;

public class Round {

    public void play(List<Car> carList) {
        createRandom(carList);
        OutputView.resultGame(carList);
    }

    public void createRandom(List<Car> carList) {
        for (Car car : carList) {
            RandomNumber.make();
            if (RandomNumber.isForward()) {
                car.forward();
            }
        }
    }
    
}
