package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.InputUtil;
import racingcar.model.RandomUtil;
import racingcar.view.RaceStartView;

public class GameController {

    private List<Car> carObjects;
    private int lap;

    public void run() {
        RaceStartView raceStartView = new RaceStartView();

        String carName = raceStartView.getCarName();
        String[] carNameStrings = InputUtil.splitCarName(carName);

        String raceLap = raceStartView.getRaceLap();

        carObjects = new ArrayList<>();
        for (String carNameStr : carNameStrings) {
            carObjects.add(new Car(carNameStr));
        }

        lap = Integer.parseInt(raceLap);

        for (int i = 0; i < lap; i++) {
            oneLap();
        }
    }

    private void oneLap() {
        for (Car car : carObjects) {
            if (RandomUtil.moveForwardOrNot()) {
                car.moveForward();
            }
        }
    }
}
