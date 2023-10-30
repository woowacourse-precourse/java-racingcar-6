package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManageController {
    public void play() {
        OutputView.enterCarNames();
        String names = InputView.inputCarNames();
        List<String> namesList = List.of(names.split(","));
        List<Car> carList = new ArrayList<Car>();

        for (String name : namesList) {
            Car car = new Car(name);
            carList.add(car);
        }

        OutputView.enterAttempts();
        int attempts = InputView.inputAttempts();

        for (int i = 0; i < attempts; i++) {
            for (Car car : carList) {
                car.move();
            }
        }
    }


}
